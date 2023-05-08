class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        int len = dp.length;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                dp[i][j] = land[i][j];
            }
        }
        int max = 0, maxIdx = 0;
        int secMax = 0, secMaxIdx = 0;
        
        for (int i = 0; i < dp.length - 1; i++) {
            max = secMax = 0;
            
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] >= max) {
                    secMax = max;
                    secMaxIdx = maxIdx;
                    max = dp[i][j];
                    maxIdx = j;                    
                } else if (dp[i][j] >= secMax) {
                    secMax = dp[i][j];
                    secMaxIdx = j;
                }
            }
            
            for (int k = 0; k < land[i].length; k++) {
                dp[i + 1][k] += (k != maxIdx)? max : secMax;
            }
        }
        
        return Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), Math.max(dp[len - 1][2], dp[len - 1][3]));
    }
}