class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        for (int num : array) {
            int diff = Math.abs(num - n);
            if (diff < minDiff) {
                minDiff = diff;
                answer = num;
            }
            else if (diff == minDiff) answer = Math.min(answer, num);
        }
        
        return answer;
    }
}