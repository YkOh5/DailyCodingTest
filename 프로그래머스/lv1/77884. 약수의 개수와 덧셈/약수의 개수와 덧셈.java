class Solution {
    public int solution(int left, int right) {        
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int numOfDiv = 1;   // 약수의 개수
            for (int j = 1; j <= i / 2; j++) {
                // 정수로 나누어 떨어지는 경우
                if (i % j == 0) {
                    numOfDiv++;
                }
            }
            // 약수의 개수가 짝수인 경우
            if (numOfDiv % 2 == 0) {
                answer += i;
            // 홀수인 경우
            } else {
                answer -= i;
            }
        }
        
        return answer;
        
        
        // 제곱수인 경우에만 약수의 개수가 홀수인 것을 이용하면, 더 간단한 코드로 더 빠르게 해결 가능
        // int answer = 0;
        // for (int i = left; i <= right; i++) {
        //     if (i % Math.sqrt(i) == 0) {
        //         answer -= i;
        //     } else {
        //         answer += i;
        //     }
        // }        
        // return answer;
    }
}