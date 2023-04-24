// 1. n+1행 m+1열의 배열을 생성
// 2. 출발 구역의 값은 1, 침수 구역의 값은 -1로 설정
// 3. 그 외 구역은 위쪽과 왼쪽 구역의 값을 더한 값으로 설정 (※최단경로이므로 오른쪽이나 아래쪽으로만 이동 가능)
// 4. 왼쪽이나 위쪽 구역이 침수됐다면 해당 구역은 합에서 제외
// 5. 배열의 마지막 원소값 = 최단경로의 개수

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        
        // 침수 구역의 값 = -1
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
            }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 시작 구역의 값 = 1
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                // 침수 구역이 아닌 경우
                } else if (dp[i][j] != -1) {
                    if (dp[i-1][j] < 0 && dp[i][j-1] >= 0) {   // 위쪽 구역이 침수된 경우
                        dp[i][j] = dp[i][j-1];
                    } else if (dp[i-1][j] >= 0 && dp[i][j-1] < 0) {   // 왼쪽 구역이 침수된 경우
                        dp[i][j] = dp[i-1][j];
                    }  else if (dp[i-1][j] >= 0 && dp[i][j-1] >= 0) {   // 두 구역 모두 침수되지 않은 경우
                        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                    }                    
                } 
            }
        }
        
        return dp[n][m];
    }
}
