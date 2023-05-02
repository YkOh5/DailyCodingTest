// 1. 각 배열에서 가장 큰 수와 가장 작은 수 순서로 곱할 때 기대값이 가장 작다
// 2. 오름차순으로 정렬 후 서로 반대의 순서대로 각각의 원소들을 곱한 값을 누적시킨다

import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int sum = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - 1 - i];
        }

        return sum;
    }
}