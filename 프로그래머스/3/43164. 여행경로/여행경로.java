import java.util.*;

class Solution {
    Map<String, List<Integer>> fromTo = new HashMap<>();
    String[][] tickets;
    boolean[] used;
    List<String> answer = new ArrayList<>();
    int n;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.n = tickets.length;
        this.used = new boolean[n];

        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });

        for (int i = 0; i < n; i++) {
            String from = tickets[i][0];
            fromTo.computeIfAbsent(from, k -> new ArrayList<>()).add(i);
        }

        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", 0, path);

        return answer.toArray(new String[0]);
    }

    private boolean dfs(String from, int usedCount, List<String> path) {
        if (usedCount == n) {
            answer = new ArrayList<>(path);
            return true;
        }

        List<Integer> edges = fromTo.get(from);
        if (edges == null) return false;

        for (int idx : edges) {
            if (used[idx]) continue;

            used[idx] = true;
            String dest = tickets[idx][1];
            path.add(dest);

            if (dfs(dest, usedCount + 1, path)) return true;

            path.remove(path.size() - 1);
            used[idx] = false;
        }
        return false;
    }
}
