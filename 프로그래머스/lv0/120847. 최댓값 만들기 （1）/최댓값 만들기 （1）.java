class Solution {
    public int solution(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        
        for (int number : numbers) {
            if (number > max) {
                secMax = max;
                max = number;
            } else if (number > secMax) {
                secMax = number;
            }
        }
        
        return max * secMax;
    }
}


// import java.util.Arrays;

// class Solution {
//     public int solution(int[] numbers) {
//         Arrays.sort(numbers);
//         return numbers[numbers.length - 1] * numbers[numbers.length - 2];
//     }
// }