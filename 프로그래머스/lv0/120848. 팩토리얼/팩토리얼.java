class Solution {
    public int solution(int n) {
        int answer = 1;
        while (factorial(answer) <= n) {
            answer++;
        }
        
        return --answer;
    }
    
    private int factorial(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        
        return product;
    }
}