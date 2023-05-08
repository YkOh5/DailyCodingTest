import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                dp[i][j] = land[i][j];
            }
        }
        
        for (int i = 0; i < land.length - 1; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) continue;
                    dp[i + 1][k] = Math.max(dp[i + 1][k], land[i + 1][k] + dp[i][j]);
                }
            }
        }
        
        int maxScore = 0;
        for (int score : dp[land.length - 1]) {
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}


// class Solution {
//     int solution(int[][] land) {
//         for (int i = 0; i < land.length - 1; i++) {
//             int max = 0, maxIdx = 0;
//             int secMax = 0, secMaxIdx = 0;

//             for (int j = 0; j < land[i].length; j++) {
//                 if (land[i][j] >= max) {
//                     secMax = max;
//                     secMaxIdx = maxIdx;
//                     max = land[i][j];
//                     maxIdx = j;
//                 } else if (land[i][j] >= secMax) {
//                     secMax = land[i][j];
//                     secMaxIdx = j;
//                 }
//             }

//             for (int k = 0; k < land[i + 1].length; k++) {
//                 land[i + 1][k] += (k != maxIdx)? max : secMax;
//             }
//         }
        
//         int maxScore = 0;
//         for (int score : land[land.length - 1]) {
//             maxScore = Math.max(maxScore, score);
//         }

//         return maxScore;
//     }
// }
