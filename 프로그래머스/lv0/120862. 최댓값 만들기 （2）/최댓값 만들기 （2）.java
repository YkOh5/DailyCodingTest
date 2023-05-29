class Solution {
    public int solution(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                max = Math.max(max, numbers[i] * numbers[j]);
            }
        }
        
        return max;
    }
}


// 위쪽 코드의 시간복잡도는 O(N^2)이고, 아래쪽 코드의 시간복잡도는 O(N * log N)이므로
// 배열의 크기가 커질수록 아래의 코드가 더 효율적이다
// import java.util.Arrays;

// class Solution {
//     public int solution(int[] numbers) {
//         Arrays.sort(numbers);
//         int len = numbers.length;
        
//         return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
//     }
// }