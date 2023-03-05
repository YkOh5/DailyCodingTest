class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;   // x부터 시작
        
        // 0부터 n-1까지 n개
        for (int i = 1; i < n; i++) {
            // x씩 증가
            answer[i] = answer [i-1] + x;
        }        
        
        return answer;
    }
}