class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int targetIdx = (num % 2 != 0)? num / 2 : num / 2 - 1;
        answer[targetIdx] = total / num;
        
        for (int i = targetIdx; i < num - 1; i++) {
            answer[i + 1] = answer[i] + 1;
        }
        
        for (int i = targetIdx - 1; i >= 0; i--) {
            answer[i] = answer[i + 1] - 1;
        }
        
        return answer;
    }
}


// 등차수열의 합 공식을 응용하면 훨씬 간단한 코드로 해결 가능
// class Solution {
//     public int[] solution(int num, int total) {
//         int[] answer = new int[num];
//         for (int i = 0; i < num; i++) {
//             answer[i] = (total * 2 / num - num + 1) / 2 + i;
//         }
        
//         return answer;
//     }
// }