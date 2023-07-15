// class Solution {
//     public int[][] solution(int n) {
//         int[][] answer = new int[n][n];
//         int num = 1;
//         int row = 0, column = 0;
//         int mode = 0, loopCnt = n;

//         while (num <= n * n) {
//             for (int i = 0; i < loopCnt; i++) {
//                 answer[row][column] = num++;                
//                 if (i == loopCnt - 1) mode = (mode + 1) % 4;                
//                 switch (mode) {
//                     case 0 -> column++;
//                     case 1 -> row++;
//                     case 2 -> column--;
//                     case 3 -> row--;
//                 }
//             }
//             if (mode % 2 != 0) loopCnt--;
//         }

//         return answer;
//     }
// }



// 변위를 사용한 코드가 유지보수 측면에서 더 좋을 수 있다
class Solution {
    public int[][] solution(int n) {
        int[][] distance = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] answer = new int[n][n];
        int row = 0, column = 0;        
        int num = 1, idx = 0;
        
        while (num <= n * n) {
            answer[row][column] = num++;
            int nRow = row + distance[idx][0];
            int nColumn = column + distance[idx][1];
            
            if (nRow < 0 || nRow >= n || nColumn < 0 || nColumn >= n || answer[nRow][nColumn] != 0) {
                idx = (idx + 1) % 4;
                nRow = row + distance[idx][0];
                nColumn = column + distance[idx][1];
            }
            
            row = nRow;
            column = nColumn;
        }
        
        return answer;
    }
}