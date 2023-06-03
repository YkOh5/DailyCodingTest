class Solution {
    public int solution(int i, int j, int k) {
        int cnt = 0;
        for (int num = i; num <= j; num++) {
            for (char c : String.valueOf(num).toCharArray()) {
                if (Character.getNumericValue(c) == k) cnt++;
            }
        }
        
        return cnt;
    }
}