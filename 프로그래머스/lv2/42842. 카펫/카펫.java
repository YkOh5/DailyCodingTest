// 1. 격자의 총 개수 = 가로 길이 * 세로 길이
// 2. 외곽(갈색)을 제외한 격자(노란색)의 개수 = (가로 길이 - 2) * (세로 길이 - 2)

class Solution {
    public int[] solution(int brown, int yellow) {
        int cnt = 0;
        int[] answer = new int[2];
        
        for (int i = 1; i * i <= brown + yellow; i++) {
            // 카펫의 가로와 세로의 길이가 같은 경우
            if (i * i == brown + yellow && (i - 2) * (i - 2) == yellow) {
                answer[0] = answer [1] = i;
            }
            // 카펫의 가로와 세로의 길이가 다른 경우
            else if ((brown + yellow) % i == 0 && (i - 2) * ((brown + yellow) / i -  2) == yellow) {
                answer[0] = (brown + yellow) / i;
                answer[1] = i;
            }
        }
        
        return answer;
    }
}