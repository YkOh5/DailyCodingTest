class Solution {
    public int solution(int[] array, int n) {
        int cnt = 0;
        for (int number : array) {
            if (number == n) cnt++;
        }
        
        return cnt;
    }
}