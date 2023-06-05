import java.util.ArrayList;

class Solution {
    public Integer[] solution(int n) {
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) primeList.add(i);
        }
        
        return primeList.toArray(new Integer[0]);
    }
    
    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}