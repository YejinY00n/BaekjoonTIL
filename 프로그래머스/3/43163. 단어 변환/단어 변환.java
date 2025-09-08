import java.util.*;

class Node {
    String word;
    int dist;
    
    Node(String word, int dist) {
        this.word = word;
        this.dist = dist;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node node = q.remove();
            
            // 최소한으로 target 도달이라면 종료
            if(node.word.equals(target)) {
                return node.dist;
            }
            
            // 근처 단어로 바꿀 수 있는지 검사
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && isNextWord(node.word, words[i])) {
                    q.add(new Node(words[i], node.dist+1));
                    visited[i] = true;
                }
            }
            
        }
        
        return 0;
    }
    

    
    public boolean isNextWord(String nowWord, String nextWord) {
        if(nowWord.length() != nextWord.length()) {
            return false;
        }
        
        int diff = 0;
        
        for(int i=0; i<nowWord.length(); i++) {
            if(nowWord.charAt(i) != nextWord.charAt(i)) {
                diff++;
            }
        }
        
        if(diff == 1) {
            return true;
        } else {
            return false;
        }
    }
}


/*


BFS 로 도전

변환 가능한 경우를 (철자 하나만 다른 경우) 하나씩 나열해서 target 단어가 되면 종료

최소 길이면 (or 1이면) return
아니면 0 return

*/