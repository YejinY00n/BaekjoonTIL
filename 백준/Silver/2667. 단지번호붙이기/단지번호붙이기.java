import java.util.*;

class Node {
    int x;
    int y;
    
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static void main(String agrs[]) {
        //1인 노드 발견하면 탐색
        //방문 처리는 0으로 변경
        //BFS
        
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> house = new ArrayList<>();        // 단지 수
        
        // N x N 크기 입력
        int n = sc.nextInt();
        int map[][] = new int[n][n];
        
        // 지도 입력
        for(int i=0; i<n; i++) {
            String tmp = sc.next();
            for(int j=0; j<n; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }   
        }
        
        
        //탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    int count = 1;    // 단지 집 개수 세기
                    map[i][j] = 0;        // 탐색 처리
                    q.add(new Node(i, j));    // 탐색 시작 노드 추가
                    
                    // BFS 탐색
                    while(!q.isEmpty()) {
                        // 상하좌우 탐색, 벽 제외
                        Node now = q.poll();
                        int y = now.y;
                        int x = now.x;
                        
                        // 상
                        if(y!=0 && map[y-1][x] != 0) {
                            map[y-1][x] = 0;    // 탐색 처리
                            q.add(new Node(y-1, x));    // 추가
                            count++;
                        }
                        // 하
                        if(y!= n-1 && map[y+1][x] != 0) {
                            map[y+1][x] = 0;    // 탐색 처리
                            q.add(new Node(y+1, x));    // 추가
                            count++;
                        }
                        // 좌
                        if(x!=0 && map[y][x-1] != 0) {
                            map[y][x-1] = 0;    // 탐색 처리
                            q.add(new Node(y, x-1));    // 추가
                            count++;
                        }
                        // 우
                        if(x!=n-1 && map[y][x+1] != 0) {
                            map[y][x+1] = 0;    // 탐색 처리
                            q.add(new Node(y, x+1));    // 추가
                            count++;
                        }
                    }
                    // 단지 탐색 종료
                    q.clear();
                    house.add(count);
                }
            }
        }
        
        Collections.sort(house);

        System.out.println(house.size());
        house.forEach(e -> System.out.println(e));
    }
}