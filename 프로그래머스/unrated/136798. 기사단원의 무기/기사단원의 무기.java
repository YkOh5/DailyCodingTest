class Solution {
    public int solution(int number, int limit, int power) {        
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += (getDivisorCnt(i) > limit)? power : getDivisorCnt(i);
        }
        
        return answer;
    }
    
    private int getDivisorCnt(int number) {
        int divisorCnt = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) divisorCnt += (i * i == number)? 1 : 2;
        }
        
        return divisorCnt;
    }
}