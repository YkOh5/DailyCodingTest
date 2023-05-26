class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;
        
        for (int element : array) {
            if (element > height) cnt++;
        }
        
        return cnt;
    }
}