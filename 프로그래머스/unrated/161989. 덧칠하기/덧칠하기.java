class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 0;   // 페인트칠의 횟수
        int rightEnd = 0;   // 페인트칠 범위의 오른쪽 끝
        
        for (int i = 0; i < section.length; i++) {
            // 구역 번호가 페인트칠 범위를 벗어나면
            if (section[i] > rightEnd) {
                cnt++;   // 페인트칠의 횟수 증가
                rightEnd = section[i] + m - 1;   // 페인트칠의 범위 갱신
            }
        }
        
        return cnt;
    }
}