import java.util.*;

class Solution {
    List<String> numArr = new ArrayList<String>();
    char charArr[];
    
    public int solution(String numbers) {
        // string --> char
        charArr = numbers.toCharArray();
        Arrays.sort(charArr);
        
        // 조합 DFS 탐색
        boolean[] visited = new boolean[charArr.length];
        dfs("", visited);
        
        // 정렬 후 소수인지 검사
        Collections.sort(numArr);
        
        int answer = 0;
        int lastNum = -1;
        
        for(String strNum: numArr) {
            int num = Integer.parseInt(strNum);
            
            // 마지막으로 검사한 숫자와 같으면 패스
            if(lastNum == num) {
                continue;
            }
            
            if(isPrime(num)) {
                answer++;
            }
            lastNum = num;
        }
        
        // System.out.println(numArr);      // 디버깅
        
        return answer;
    }
    
    public void dfs(String num, boolean[] visited) {
        for(int i=0; i<visited.length; i++) {
            // 방문하지 않았다면
            if(!visited[i]) {
                // 0 시작 x
                if(num.length() == 0 && charArr[i] == '0') {
                    continue;
                }
                
                String newNum = num+charArr[i];
                numArr.add(newNum);
                visited[i] = true;
                dfs(newNum, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num<2) {
            return false;
        }
        
        for(int i=2; i<num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}

/*

DFS 로 모든 조합 찾기 --> 그다음에 소수 검사

고려해야 하는거
- 같은 숫자 여러개
>> 모든 조합 찾아서 리스트로 저장, 리스트에 대해 소수 찾기 할 때 이전에 검사한것과 숫자가 같으면 패스

- 0
>> 제일 앞에는 못오게


*/