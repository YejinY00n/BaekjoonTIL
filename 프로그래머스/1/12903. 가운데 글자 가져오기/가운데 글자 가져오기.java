import java.util.*;

class Solution {
    public String solution(String s) {
        int size = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        if(size%2 == 0) {
            return sb.substring(size/2-1, size/2+1);
        }
        else {
            return sb.substring(size/2, size/2+1);
        }
    }
}