class Solution {
    public int solution(int n) {
        int answer = 0;        
        
        for (int i = 1; i <= n; i++) {
            int divisorCnt = 2;            
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (j == Math.sqrt(i)) divisorCnt++;
                else if (i % j == 0) divisorCnt += 2;
                
                if (divisorCnt >= 3) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}