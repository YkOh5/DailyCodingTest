class Solution {
    public int solution(int n) {
        int cnt;        
        for (cnt = 1; cnt * 7 < n; cnt++);
            
        return cnt;
        // return (n + 6) / 7;   단 한 줄의 코드로 해결 가능
    }
}