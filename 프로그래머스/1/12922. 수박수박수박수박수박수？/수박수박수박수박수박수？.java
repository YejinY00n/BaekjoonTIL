class Solution {
    public String solution(int n) {
        String pattern1 = "수박";
        String pattern2 = "수";
        
        int n1 = n/2;
        int n2 = n%2;
        
        String answer = pattern1.repeat(n1)+pattern2.repeat(n2);
        return answer;
    }
}