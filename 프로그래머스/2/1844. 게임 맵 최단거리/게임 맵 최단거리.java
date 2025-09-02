import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;


        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int x = now[0];
            int y = now[1];
            int move = now[2];
            
            if (x == n-1 && y == m-1) {
                return move;
            }
            
            if(x!=0 && !visited[x-1][y] && maps[x-1][y] == 1) {
                visited[x-1][y] = true;
                q.add(new int[] {x-1, y, move+1});
            }
            if(x<n-1 && !visited[x+1][y] && maps[x+1][y] == 1) {
                visited[x+1][y] = true;
                q.add(new int[] {x+1, y, move+1});
            }
            if(y!=0 && !visited[x][y-1] && maps[x][y-1] == 1) {
                visited[x][y-1] = true;
                q.add(new int[] {x, y-1, move+1});
            }
            if(y<m-1 && !visited[x][y+1] && maps[x][y+1] == 1) {
                visited[x][y+1] = true;
                q.add(new int[] {x, y+1, move+1});
            }
            
        }
        
        return -1;
    }

}

/*

6시 시작

모든 출구에 도달할 수 있는 경로 탐색
그 경로들 중 가장 짧은 경로 갱신
BFS

*/