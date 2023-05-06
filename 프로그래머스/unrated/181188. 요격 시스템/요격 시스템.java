import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);   // 각 구간의 끝점을 기준으로 오름차순으로 정렬
        int curEndPoint = 0;   // 현재 구간의 끝점
        int cnt = 0;
        
        for (int[] target : targets) {
            if (target[0] >= curEndPoint) {   // 해당 구간의 시작점이 현재 구간의 끝점과 같거나 더 뒤일 때
                cnt++;   // 필요 요격 미사일 수 증가
                curEndPoint = target[1];   // 현재 구간의 끝점 갱신
            }
        }
        
        return cnt;
    }
}