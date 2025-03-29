import java.util.*;

class Node {
    int y;
    int x;
    
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] maze = new int[row][col];
        
        // 미로 초기화
        for(int i=0; i<row; i++) {
            String tmp = sc.next();
            for(int j=0; j<col; j++) {
                maze[i][j] = tmp.charAt(j)-'0';
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        int x = 0;    // col
        int y = 0;    // row
        q.add(new Node(0, 0));   // 노드의 좌표값 push
        Node top;
        
        // BFS 탐색
        // 상하좌우 처리
        while(!q.isEmpty()) {
            top = q.poll();
            y = top.y;
            x = top.x;
            
            // 현재 노드 상하좌우 탐색
            // 우
            if(x != col-1) {
                // 벽이면 스킵
                if(maze[y][x+1] == 0) {
                }
                // 미탐색한 노드
                else if(maze[y][x+1] == 1) {
                    maze[y][x+1] = maze[y][x]+1; // 방문처리
                    
                    // 도착지가 아니라면 push
                    if(!(y == row-1 && x+1 == col-1))
                        q.add(new Node(y, x+1));
                }
                // 탐색했지만 더 긴 경로인 경우 갱신
                else if(maze[y][x+1] > maze[y][x]+1 ) {
                    maze[y][x+1] = maze[y][x]+1;
                    
                    // 도착지가 아니라면 push
                    if(!(y == row-1 && x+1 == col-1))
                        q.add(new Node(y, x+1));
                }
            }
            // 하
            if(y != row-1) {
                // 벽이면 스킵
                if(maze[y+1][x] == 0) {
                }
                // 미탐색한 노드
                else if(maze[y+1][x] == 1) {
                    maze[y+1][x] = maze[y][x]+1;
                    // 도착지가 아니라면 push
                    if(!(y+1 == row-1 && x == col-1))
                        q.add(new Node(y+1, x));
                }
                // 탐색했지만 더 긴 경로인 경우 갱신
                else if(maze[y+1][x] > maze[y][x]+1 ) {
                    maze[y+1][x] = maze[y][x]+1;
                    // 도착지가 아니라면 push
                    if(!(y+1 == row-1 && x == col-1))
                        q.add(new Node(y+1, x));
                }
            }
            // 좌
            if(x != 0) {
                // 벽이면 스킵
                if(maze[y][x-1] == 0) {
                }
                // 미탐색한 노드
                else if(maze[y][x-1] == 1) {
                    maze[y][x-1] = maze[y][x]+1;
                    // 도착지가 아니라면 push
                    if(!(y == row-1 && x-1 == col-1))
                        q.add(new Node(y, x-1));
                }
                // 탐색했지만 더 긴 경로인 경우 갱신
                else if(maze[y][x-1] > maze[y][x]+1 ) {
                    maze[y][x-1] = maze[y][x]+1;
                    // 도착지가 아니라면 push
                    if(!(y == row-1 && x-1 == col-1))
                        q.add(new Node(y, x-1));
                }
            }
            
            // 상
            if(y != 0) {
                // 벽이면 스킵
                if(maze[y-1][x] == 0) {
                }
                // 미탐색한 노드
                else if(maze[y-1][x] == 1) {
                    maze[y-1][x] = maze[y][x]+1;
                    // 도착지가 아니라면 push
                    if(!(y-1 == row-1 && x == col-1))
                        q.add(new Node(y-1, x));
                }
                // 탐색했지만 더 긴 경로인 경우 갱신
                else if(maze[y-1][x] > maze[y][x]+1 ) {
                    maze[y-1][x] = maze[y][x]+1;
                    // 도착지가 아니라면 push
                    if(!(y-1 == row-1 && x == col-1))
                        q.add(new Node(y-1, x));
                }
            }
        }
        
        System.out.println(maze[row-1][col-1]);
    }
}