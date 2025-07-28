import java.util.*;

class Solution {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static int count = 0;     // 몇 번째 단어인지 카운트
    static int answer = 0;    // 정답 저장

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    public void dfs(String current, String target) {
        if (current.equals(target)) {
            answer = count;
            return;
        }

        if (current.length() == 5) return; // 길이 제한

        for (int i = 0; i < vowels.length; i++) {
            count++;
            dfs(current + vowels[i], target);
            if (answer != 0) return; // 이미 찾았으면 더 탐색 안 함
        }
    }
}


/*

5시 시작

A E I O U
- 순서대로 하나씩 조합해서 몇번째에 찾는 단어가 나오는 지 알아내기

*/