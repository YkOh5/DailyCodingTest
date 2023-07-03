class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denomLCM = getLCM(denom1, denom2);
        int sumNumer = numer1 * (denomLCM / denom1) + numer2 * (denomLCM / denom2);
        int GCD = getGCD(denomLCM, sumNumer);        
        
        return new int[]{sumNumer / GCD, denomLCM / GCD};
    }
    
    // 뉴클리드 호제법
    private int getGCD(int num1, int num2) {
        if (num2 == 0) return num1;
        
        return getGCD(num2, num1 % num2);
    }
    
    private int getLCM(int num1, int num2) {
        return num1 * num2 / getGCD(num1, num2);
    }
}