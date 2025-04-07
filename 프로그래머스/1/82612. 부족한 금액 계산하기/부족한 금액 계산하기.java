class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        answer = (long)money - (long)price*(((long)count*((long)count+1))/2);
        
        if(answer >= 0)
            return 0;
        else
            return -answer;
    }
}