/*
yellow의 너비x높이 구하기

yellow가 어떤 너비x높이 일때, 해당 직사각형의 테두리 길이가 brown과 같다면 해당 값을 리턴
만약 너비가 높이 보다 작다면, 값을 swap하여 return

직사각형은 돌리면 어차피 같은 크기 이므로
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int wid=1; wid<=yellow; wid++) {
            if(yellow%wid == 0) {
                int hgt = yellow/wid;
                int border = ((wid+2)*2)+((hgt+2)*2)-4;
                
                if(border == brown) {
                    hgt += 2;
                    wid += 2;
                    if(hgt > wid) {
                        int tmp = hgt;
                        hgt = wid;
                        wid = tmp;
                    }
                    return new int[] {wid, hgt};
                }
            }
        }
        
        int[] answer = {};
        return answer;
    }
}