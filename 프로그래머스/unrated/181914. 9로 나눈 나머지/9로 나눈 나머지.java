import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        return new BigInteger(number).remainder(new BigInteger("9")).intValue();
    }
}



// class Solution {
//     public int solution(String number) {
//         int sum = 0;
//         for (char num : number.toCharArray()) {
//             sum += Character.getNumericValue(num);
//         }
        
//         return sum % 9;
//     }
// }