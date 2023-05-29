class Solution {
    public int solution(int n) {
        int cnt = 1;
        while (cnt * 6 % n != 0) {
            cnt++;            
        }
        
        return cnt;
    }
}