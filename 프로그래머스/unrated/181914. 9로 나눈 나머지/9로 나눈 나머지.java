import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        return new BigInteger(number).remainder(new BigInteger("9")).intValue();
    }
}