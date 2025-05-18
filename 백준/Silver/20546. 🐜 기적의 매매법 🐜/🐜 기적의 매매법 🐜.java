import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int seed = s.nextInt();
        
        int moneySung = seed;
        int moneyJun = seed;
        int stockSung = 0;
        int stockJun = 0;
        
        int tripleUpOrDown = 0;
        
        int[] dailyStock = new int[14];
        int todayStock = 0;
        
        for(int i=0; i < 14; i++) {
            dailyStock[i] = s.nextInt();
        }
        
        for(int i=0; i < 14; i++) {
            todayStock = dailyStock[i];
            
            // 준현
            if(moneyJun / todayStock != 0) {
                stockJun += moneyJun / todayStock;
                moneyJun -= todayStock * (moneyJun / todayStock);
            }
            
            // 성민                     
            if(i>0) {
                // 전날 대비 상승 or 하락 했는지 체크
                if(dailyStock[i] > dailyStock[i-1]) {
                    if(tripleUpOrDown < 0) {
                        tripleUpOrDown = 0;
                    }
                    tripleUpOrDown += 1;
                }
                else if(dailyStock[i] < dailyStock[i-1]) {
                    if(tripleUpOrDown > 0) {
                        tripleUpOrDown = 0;
                    }
                    tripleUpOrDown -= 1;
                }
                
                // 3일 연속 상승 or 하락인지 검사
                if(tripleUpOrDown >= 3) {
                  // 전량 매도
                  moneySung += stockSung * todayStock;
                  stockSung = 0;
                  tripleUpOrDown = 0;
                  continue;
                }
                else if(tripleUpOrDown <= -3) {
                  // 전량 매수
                  stockSung += moneySung / todayStock;
                  moneySung -= todayStock * (moneySung / todayStock);
                  tripleUpOrDown = 0;
                  continue;
                }
            }
        }
        
        // 종료 후 비교
        moneyJun += stockJun * todayStock;
        moneySung += stockSung * todayStock;
        
        if(moneyJun > moneySung) {
            System.out.println("BNP");
        }
        else if(moneySung > moneyJun) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}