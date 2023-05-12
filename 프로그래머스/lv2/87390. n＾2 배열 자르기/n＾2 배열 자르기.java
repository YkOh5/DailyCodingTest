class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        
        for (long i = left; i <= right; i++) {            
            int quotient = (int)(i / n);   // 몫
            int remainder = (int)(i % n);   // 나머지
            
            answer[idx++] = Math.max(quotient, remainder) + 1;
        }
        
        return answer;
    }
}


// 조건에 따라 배열 전체를 생성해서 주어진 구간을 발췌하는 방식은 매우 비효율적
// class Solution {
//     public long[] solution(int n, long left, long right) {        
//         int[] nums = new int[n * n];        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 nums[n * i + j] = j + 1;
//             }            
//             for (int k = 0; k < i; k++) {
//                 nums[n * i + k] = i + 1;
//             }
//         }                
//         long[] answer = new long[(int)(right - left + 1)];
//         int idx = 0;
//         for (long i = left; i <= right; i++) {
//             answer[idx++] = nums[(int)i];
//         }        
//         return answer;
//     }
// }