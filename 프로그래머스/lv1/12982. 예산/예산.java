// 신청 금액이 적은 부서들부터 차례대로 지원하면 최대한 많은 부서에 물품을 지원할 수 있다

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        // 지원 가능한 부서의 수
        int cnt = 0;        
        // 부서별 신청 금액의 합
        int sum = 0;
        
        // 부서별 신청 금액을 오름차순으로 정렬
        Arrays.sort(d);
        // 부서별 신청 금액의 합이 전체 예산을 초과하기 전까지 지원할 부서의 수를 증가
        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget) {
                break;
            } else {
                sum += d[i];
                cnt++;
            }
        }
                
        return cnt;
    }
}