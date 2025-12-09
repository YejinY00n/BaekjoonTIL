import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pocketmon = new HashSet<>();
        
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        pocketmon.addAll(numsList);
        
        int numsListSize = numsList.size();
        
        if(numsListSize/2 > pocketmon.size()) {
            return pocketmon.size();
        } else {
            return numsListSize/2;
        }
    }
}