import java.util.*;

class Solution {
    int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, visited, 0, dungeons);
        
        return maxCount;
    }
    
    void dfs(int current, boolean[] visited, int cnt, int[][] dungeons){
        maxCount = Math.max(maxCount, cnt);
        
        for(int i = 0; i < dungeons.length; i++){
            int required = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(!visited[i] && required <= current) {
                visited[i] = true;
                
                dfs(current - cost, visited, cnt+1, dungeons);
                visited[i] = false;
            }
        }
    }
}
