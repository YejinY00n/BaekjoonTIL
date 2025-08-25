class Solution {
    int[][] coms;
    int num;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        coms = computers;
        num = n;
        
        for(int i=0; i<n; i++) {
            if(coms[i][i] == 1) {
                System.out.println("i: "+i);
                coms[i][i] = 0;
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        for(int i=0; i<num; i++) {
            if(coms[node][i] == 1) {
                coms[node][i] = 0;
                coms[i][node] = 0;
                coms[i][i] = 0;
                dfs(i);
            }
        }
    }
}

/*

DFS로 탐색해서 탐색 가능한 노드만 넣고, 하나의 네트워크로 처리

*/