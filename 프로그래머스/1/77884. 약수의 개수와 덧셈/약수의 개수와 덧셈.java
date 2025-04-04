class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            int result = getDiv(i);
            if(result % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    public int getDiv(int n) {
        int div = 0;
        
        for(int i = 1; i<=n; i++) {
            if(n%i == 0) div++;    
        }
        return div;
    }
}