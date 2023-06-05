import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int exponent = 0;
        while (Math.pow(2, exponent) < arr.length) exponent++;
        
        return Arrays.copyOfRange(arr, 0, (int)Math.pow(2, exponent));
    }
}