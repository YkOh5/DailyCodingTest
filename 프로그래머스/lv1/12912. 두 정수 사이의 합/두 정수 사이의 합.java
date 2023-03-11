class Solution {
    public long solution(int a, int b) {
        // 정수의 합이 int의 범위를 벗어날 수 있으므로 long으로 선언
        // int의 크기 : 4byte(=32bit), 범위 : -2,147,483,648(=-2^31) ~ 2,147,483,647(=2^31-1)
        // long의 크기 : 8byte(=64bit), 범위 : -2^63 ~ 2^63-1
        long sum = 0;
        
        // a가 b보다 큰 경우
        if (a < b) {
            // a부터 b까지 1씩 증가하며 더한다
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        // a가 b보다 작거나 같은 경우
        } else {
            // a부터 b까지 1씩 감소하며 더한다
            for (int i = a; i >= b; i--) {
                sum += i;
            }
        }
        
        return sum;
    }
}