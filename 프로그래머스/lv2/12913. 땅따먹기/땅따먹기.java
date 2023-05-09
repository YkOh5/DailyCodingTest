// 중복 계산을 피하기 위해서 동적 프로그래밍(Dynamic Programming) 기법을 활용

class Solution {
    int solution(int[][] land) {
        for (int i = 0; i < land.length - 1; i++) {
            int max = 0, maxIdx = 0;   // 해당 행의 최대값과 그 인덱스
            int secMax = 0, secMaxIdx = 0;   // 두 번째로 큰 값과 그 인덱스

            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] > max) {   // 해당 원소가 소속 행의 최대값일 경우
                    secMax = max;
                    secMaxIdx = maxIdx;
                    max = land[i][j];
                    maxIdx = j;
                } else if (land[i][j] > secMax) {   // 두 번째로 큰 값일 경우 
                    secMax = land[i][j];
                    secMaxIdx = j;
                }
            }
            
            // 다음 행에 속한 원소들 중
            for (int k = 0; k < land[i + 1].length; k++) {
                // 이전 행의 최대값이 속한 열과 다른 열의 원소에는 최대값을 더하고
                // 같은 열에 속한 원소에는 두 번째로 큰 값을 더한다
                land[i + 1][k] += (k != maxIdx)? max : secMax;
            }
        }
        
        int maxScore = 0;
        for (int score : land[land.length - 1]) {
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}


// 아래와 같이 3중 반복문을 사용하면 코드 자체는 간결해지지만, 처리속도가 떨어진다
// class Solution {
//     int solution(int[][] land) {
//         int[][] dp = new int[land.length][land[0].length];
//         for (int i = 0; i < land.length; i++) {
//             for (int j = 0; j < land[i].length; j++) {
//                 dp[i][j] = land[i][j];
//             }
//         }        
//         for (int i = 0; i < land.length - 1; i++) {
//             for (int j = 0; j < land[i].length; j++) {
//                 for (int k = 0; k < land[i].length; k++) {
//                     if (j == k) continue;
//                     dp[i + 1][k] = Math.max(dp[i + 1][k], land[i + 1][k] + dp[i][j]);
//                 }
//             }
//         }        
//         int maxScore = 0;
//         for (int score : dp[land.length - 1]) {
//             maxScore = Math.max(maxScore, score);
//         }        
//         return maxScore;
//     }
// }