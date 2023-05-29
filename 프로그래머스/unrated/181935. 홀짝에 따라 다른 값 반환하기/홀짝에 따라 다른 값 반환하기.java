class Solution {
    public int solution(int n) {
        return (n % 2 != 0)? sumOdd(n) : sumEven(n);
    }
    
    private int sumOdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) sum += i;
        
        return sum;
    }
    
    private int sumEven(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) sum += i * i;
        
        return sum;
    }
}