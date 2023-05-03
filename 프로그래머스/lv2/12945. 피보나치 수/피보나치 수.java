// 배열을 이용한 다이나믹 프로그래밍으로 시간복잡도를 O(n)으로 줄일 수 있다

class Solution {
    public int solution(int n) {
        int[] fib = new int[n + 1];
        fib[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }        
        
        return fib[n];
    }
}