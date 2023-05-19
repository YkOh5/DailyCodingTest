// 최대값 1백만이 주어진 경우 이를 3진수로 변환하면 약 100억으로 이는 int의 범위인 +-21억 가량을 벗어나므로 long을 써야 한다

class Solution {
    private String convertedNumber;
    private StringBuilder sb = new StringBuilder();
    private int cntPrimeNums = 0;
    
    public int solution(int n, int k) {
        this.convertedNumber = Long.toString(n, k);
        
        for (int i = 0; i < convertedNumber.length(); i++) {
            char target = convertedNumber.charAt(i);
            if (target != '0') {
                sb.append(target);
            }
            
            if (target == '0' || i == convertedNumber.length() - 1) {
                if (sb.length() > 0 && isPrime(Long.parseLong(sb.toString()))) cntPrimeNums++;
                sb.setLength(0);
            }
        }
        
        return cntPrimeNums;
    }
    
    private boolean isPrime(long number) {
        if (number <= 1) return false;
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}