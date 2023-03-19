class Solution {
    public int solution(int[] a, int[] b) {
        int scalar = 0;
        // 주어진 두 배열의 각 원소들을 서로 곱한 값을 누적
        for (int i = 0; i < a.length; i++) {
            scalar += a[i] * b[i];
        }
        
        return scalar;
    }
}