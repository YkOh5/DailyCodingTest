// 1. n번째 칸에 도달하는 경우의 수는 마지막에 한 칸을 뛰는 경우와 마지막에 두 칸을 뛰는 경우로 나누어 구할 수 있다
// 2. 전자는 마지막의 한 칸을 제외한 (n−1) 번째 칸에 도달하는 경우의 수와 같다
// 3. 후자는 마지막의 두 칸을 제외한 (n−2) 번째 칸에 도달하는 경우의 수와 같다
// 4. 즉, 처음의 두 항이 1과 2인 피보나치 수열로 나타낼 수 있다

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