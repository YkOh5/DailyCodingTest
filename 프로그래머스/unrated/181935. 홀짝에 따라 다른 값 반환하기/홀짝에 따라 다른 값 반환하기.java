class Solution {
    public int solution(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) sumOdd += i;
            else sumEven += i * i;
        }
        
        return (n % 2 != 0)? sumOdd : sumEven;
    }
}