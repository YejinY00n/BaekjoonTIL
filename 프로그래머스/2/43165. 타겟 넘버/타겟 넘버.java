import java.util.*;

class Solution {
    int answer = 0;
    int[] nums;
    int targetNum;
    
    public int solution(int[] numbers, int target) {
        boolean[][] visited = new boolean[numbers.length][2];
        nums = numbers;
        targetNum = target;
        
        dfs(visited, 0, 0);
        
        return answer;
    }
    
    void dfs(boolean[][] visited, int index, int sum) {
        if(index >= nums.length) {            
            if(sum == targetNum) {
                answer++;
            }
            return;
        }
        
        for(int i=0; i<2; i++) {
            if(!visited[index][i]) {
                visited[index][i] = true;
                dfs(visited, index+1, (sum+nums[index]*(i==0?1:-1)));
                visited[index][i] = false;
            }
        }
    }
}

/*
2시 35분 시작

dfs로 탐색
마지막 숫자 더했을 때 타겟이면 answer++

*/