class Solution {
    public int[] solution(int n, int m) {
        // 최대 공약수
        int min = n < m? n:m;
        int max = n > m? n:m;
        
        int max_div = 1;
        
        for(int i=1; i<=min; i++) {
            if(n%i==0 && m%i==0) {
                max_div = i;
            }
        }
        
        int min_mult = 1;
        
        // 최소 공배수
        for(int i=max; ; i++) {
            if(i%n==0 && i%m==0) {
                min_mult = i;
                break;
            }
        }
        int [] answer = {max_div, min_mult};
        return answer;
    }
}