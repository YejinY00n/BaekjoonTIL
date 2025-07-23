import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        boolean[][] map = new boolean[n+1][n+1]; // n+1 x n+1 크기 맵
        
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            map[v1][v2] = true;
            map[v2][v1] = true;
        }
        
        int answer = n;
        
        for(int i=0; i<wires.length; i++) {
            // 연결 끊기
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            map[v1][v2] = false;
            map[v2][v1] = false;
            
            // 탐색
            int gap = searchMap(n, v1, map);
            
            if(gap < answer) {
                answer = gap;
            }
            
            // 끊어진 연결 복구
            map[v1][v2] = true;
            map[v2][v1] = true;
        }
        
        return answer;
    }
    
    // DFS 탐색
    int searchMap(int totalNode, int start, boolean[][] map) {
        // 탐색한 노드 저장
        boolean[] visited = new boolean[totalNode+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int count = 1;
        
        while(!stack.isEmpty()) {
            int nowNode = stack.pop();    // 마지막 노드 가져오기
            
            // 현재 노드에서 갈 수 있는 길 탐색
            for(int i=1; i<=totalNode; i++) {
                if (map[nowNode][i] && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        
        return Math.abs((totalNode-count) - count);
    }
}

// 6시 40분 시작

/*

어떤 연결 하나를 끊기
끊어진 연결의 한쪽 노드부터 탐색시작해서 갈 수 있는 모든 노드 구함 = A
총 송전탑 개수 N - A = B 다른 영역 쪽의 노드(송전탑)

이걸 모든 연결에 대해서 수행하고, A-B의 최소 절대값 구하기

*/