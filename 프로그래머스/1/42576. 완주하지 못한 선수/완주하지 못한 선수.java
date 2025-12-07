import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        
        for(String part:participant) {
            participantMap.put(part, participantMap.getOrDefault(part, 0)+1);
        }
        
        for(String comp:completion) {
            participantMap.put(comp, participantMap.get(comp)-1);
        }
        
        for(String key:participantMap.keySet()) {
            if(participantMap.get(key) > 0) {
                return key;
            }
        }
        
        String answer = "";
        return answer;
    }
}