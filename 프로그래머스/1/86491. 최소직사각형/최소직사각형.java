/*

모든 경우의 수를 탐색?
최소 직사각형 구하는 알고리즘

n개의 명함이 있을 때
최대 가로 길이, 최대 세로 길이를 곱한 게 지갑의 크기
이걸 2^n 경우의 수 만큼 탐색하여 최소값 찾기

*/

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}