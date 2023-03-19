class Solution {
    public int solution(int left, int right) {
        
        int answer = 0;        
        
        for (int i = left; i <= right; i++) {
            int numOfDiv = 1;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    numOfDiv++;
                }
            }
            if (numOfDiv % 2 ==0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}