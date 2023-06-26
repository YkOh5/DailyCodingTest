class Solution {
    public int solution(int n) {
        int answer = 0;        
        for (int i = 0; i < n; i++) {
            while (String.valueOf(answer + 1).indexOf("3") != -1 || (answer + 1) % 3 == 0) answer++;
            answer++;
        }
        
        return answer;
    }
}