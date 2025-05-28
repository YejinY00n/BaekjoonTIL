import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int answer1[] = {1, 2, 3, 4, 5};
        int answer2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int answer3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == answer1[i%5]) {
                score1++;
            }
            if(answers[i] == answer2[i%8]) {
                score2++;
            }
            if(answers[i] == answer3[i%10]) {
                score3++;
            }
        }
        if(score1==score2 && score2==score3) {
            return new int[] {1, 2, 3};
        }
        
        int maxScore = Math.max(score1, Math.max(score2, score3));
        
        List<Integer> result = new ArrayList<>();
        if(score1 == maxScore) result.add(1);
        if(score2 == maxScore) result.add(2);
        if(score3 == maxScore) result.add(3);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}