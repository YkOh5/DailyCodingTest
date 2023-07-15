class Solution {
    public long solution(int balls, int share) {
        long answer = 1;
        int diff = balls - share;
        for (int i = share + 1; i <= balls; i++) {
            answer *= i;
            if (i - share <= diff) answer /= i - share;
        }
        
        return answer;
    }
}