class Solution {
    public int[] solution(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        int[] answer = new int[sum];
        int idx = 0;
        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                answer[idx++] = num;
            }
        }
        
        return answer;
    }
}