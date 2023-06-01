import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        return Integer.parseInt(new BigInteger(number).remainder(new BigInteger("9")).toString());
    }
}