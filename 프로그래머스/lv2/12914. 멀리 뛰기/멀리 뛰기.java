class Solution {
    public long solution(int n) {
        if (n < 3) return n;
        
        long[] fib = new long[n + 1];
        fib[1] = 1;
        fib[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }
        
        return fib[n];
    }
}