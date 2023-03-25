class Solution {
    public int[] solution(int n, int m) {
        return new int[]{getGCD(n, m), getLCM(n, m)};
    }
    
    // 최대공약수
    int getGCD(int n, int m) {
        for (int i = Math.min(n, m); i >= 1; i--) {
            if (n % i == 0 && m % i == 0) return i;
        }            
        return -1;
    }
    
    // 최소공배수
    int getLCM(int n, int m) {
        return n * m / getGCD(n, m);
    }
}