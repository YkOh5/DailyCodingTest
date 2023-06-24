class Solution {
    public int solution(int a, int b) {
        if (a % b == 0) return 1;
        int reducedDenominator = b / getGCD(a, b);
        for (int i = 2; i <= reducedDenominator; i++) {
            if (reducedDenominator % i == 0 && isPrime(i) && i != 2 && i != 5) return 2;
        }
                
        return 1;
    }
    
    private int getGCD(int num1, int num2) {
        for (int i = Math.min(num1, num2); i > 1; i --) {
            if (num1 % i == 0 && num2 % i == 0) return i;            
        }
        
        return 1;
    }
    
    private boolean isPrime(int num) { 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}