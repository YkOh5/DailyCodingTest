class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int targetIdx = (num % 2 != 0)? num / 2 : num / 2 - 1;
        answer[targetIdx] = total / num;
        
        for (int i = targetIdx; i < num - 1; i++) {
            answer[i + 1] = answer[i] + 1;
        }
        
        for (int i = targetIdx - 1; i >= 0; i--) {
            answer[i] = answer[i + 1] - 1;
        }
        
        return answer;
    }
}