import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;



public class Main {
    public static void main(String args[]) {
        int cases;
        int docs;        // 인쇄할 문서의 갯수
        int cnt;         // 몇번째에 인쇄되는지
        int nowOrder;    // 순서를 알아보고자 하는 문서의 처음 순서
        Integer maxPrior;    // 현재 최대 중요도
        Integer inputTmp;
        Integer tmp;
        
        Scanner sc = new Scanner(System.in);
        Queue<Integer> printQ = new LinkedList<>();
        
        cases = sc.nextInt();
        
        for(int i=0; i<cases; i++) {
            cnt = 0;
            
            docs = sc.nextInt();
            nowOrder = sc.nextInt();
            
            // 입력 받으면서 중요도 우선순위 큐 입력
            for(int j=0; j<docs; j++) {
                inputTmp = new Integer(sc.nextInt());
                printQ.add(inputTmp);
            }
            
            maxPrior = Collections.max(printQ);
            
            while(true) {
                tmp = printQ.peek();
                // 최대 중요도에 문제가 없다는 가정 하에, 맨앞의 문서가 가장 높은 중요도라면 출력
                // 객체는 equals 로 비교할 것
                if(tmp.equals(maxPrior)) {
                    cnt++;        // 출력 횟수 증가
                    
                    // 출력하는 문서가 찾는 문서라면 종료
                    if(nowOrder == 0) {
                        System.out.println(cnt);
                        break;
                    }
                    
                    // 찾는 문서가 아니라면
                    printQ.poll();
                    docs--;
                    nowOrder--;            // 문서 순서 추적
                    
                    // 가장 높은 중요도 갱신
                    maxPrior = Collections.max(printQ);
                }
                // 가장 높은 중요도가 아니면 맨뒤로 이동
                else {
                    inputTmp = printQ.poll();
                    printQ.add(inputTmp);
                    
                    // 문서 순서 추적
                    if(nowOrder == 0)
                        nowOrder = docs - 1;
                    else {
                        nowOrder--;
                    }
                }
            }
            
            // 큐 비우기
            printQ.clear();          
        } 
    }
}
