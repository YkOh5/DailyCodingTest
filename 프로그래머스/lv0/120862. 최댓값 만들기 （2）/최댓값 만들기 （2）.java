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


// 정렬을 이용한 방식은 코드 자체는 더 간단하지만 처리속도가 느리다
// import java.util.Arrays;

// class Solution {
//     public int solution(int[] numbers) {
//         Arrays.sort(numbers);
//         int len = numbers.length;
        
//         return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
//     }
// }