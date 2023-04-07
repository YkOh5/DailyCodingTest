// 특정 범위 내 모든 소수를 찾기 위해서는 '에라토스테네스의 체'를 사용하는 것이 효율적이다
// 1. 모든 수를 하나씩 검사하는 방식이 아니라, 소수의 배수만을 검사하기 때문에 반복 횟수가 적다
// 2. 소수의 배수를 검사할 때 이미 검사된 수의 상당한 부분을 건너뛰기 때문에 중복 계산이 적다

class Solution {
    public int solution(int n) {
        // 배열의 인덱스와 소수가 일치하도록 배열의 크기를 배정
        boolean[] primeNums = new boolean[n + 1];        
        
        // 우선 2 이상의 모든 양의 정수를 소수로 가정
        for (int i = 2; i <= n; i++) {
            primeNums[i] = true;
        }
        
        // '에라토스테네스의 체' 구현
        // i가 소수이면, i의 배수는 약수로 i를 가지고 있게 되므로 i의 배수는 소수가 아닌 것으로 처리한다
        // i가 소수가 아니면, i의 배수 역시 소수가 아니므로 검사할 필요가 없다            
        // i * (i - 1)까지는 이미 이전 단계에서 검사되었으므로 j의 시작값을 i * 2에서 i * i로 개선할 수 있다
        for (int i = 2; i * i <= n; i++) {
            if (primeNums[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeNums[j] = false;
                }
            }
        }
        
        // 배열 primeNums의 원소들 중 boolean값이 true인 원소들의 개수를 세어 반환한다
        int cnt = 0;        
        for (boolean item : primeNums) {
            if (item) cnt++;
        }
        
        return cnt;
        
        
        // '에라토스테네스의 체'보다는 비효율적이지만, j의 범위를 i의 제곱근까지로 한정하면 간단한 방식으로도 해결 가능
        // int answer = 0;
        // for (int i = 2; i <= n; i++) {
        //     boolean primeNum = true;
        //     for (int j = 2; j <= Math.sqrt(i); j++) {
        //         if (i % j == 0) {
        //             primeNum = false;
        //             break;
        //         }
        //     }
        //     if (primeNum) answer++;
        // }               
        // return answer;
    }
}
