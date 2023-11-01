class Solution {
    public int solution(int n) {
        for (int x = 2; x < n; x++) {
            // n을 x로 나눈 나머지가 1인 경우
            if (n % x == 1) {
                return x;
            }
        }
        
        return -1;
        
        
        // Stream을 활용하면 간결하게 해결 가능하지만, 처리속도는 상당히 떨어진다.
        // return IntStream.range(2, n).filter(i -> n % i == 0).findFirst().orElse(-1);
    }
}