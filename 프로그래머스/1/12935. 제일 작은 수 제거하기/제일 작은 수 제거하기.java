import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        list.remove(minIndex);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
