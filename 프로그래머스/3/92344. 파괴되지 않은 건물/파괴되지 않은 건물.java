// 누적합을 이용하면 시간복잡도가 O(N * M + K) = 1,000 * 1,000 + 250,000 = 35만인 반면에
// 각 스킬을 사용할 때마다 보드를 갱신하면 시간복잡도가 O(N * M * K) = 3500억이 되므로 시간초과!!!

class Solution {
    private int[][] tBoard;
    
    public int solution(int[][] board, int[][] skills) {
        tBoard = new int[board.length + 1][board[0].length + 1];
        
        useSkills(skills);
        
        getCumulativeSum();
        
        return cntStandingBuildings(board);
    }
    
    private void useSkills(int[][] skills) {
        for (int[] skill : skills) {
            int sign = (skill[0] == 1)? -1 : 1;
            int dHP = sign * skill[5];
            
            tBoard[skill[1]][skill[2]] += dHP;            
            tBoard[skill[1]][skill[4] + 1] += -1 * dHP;
            tBoard[skill[3] + 1][skill[2]] += -1 * dHP;
            tBoard[skill[3] + 1][skill[4] + 1] += dHP;
        }    
    }
    
    private void getCumulativeSum() {
        for (int i = 0; i < tBoard.length; i++) {
            for (int j = 1; j < tBoard[i].length; j++) {
                tBoard[i][j] += tBoard[i][j - 1];
            }
        }
        
        for (int i = 0; i < tBoard[0].length; i++) {
            for (int j = 1; j < tBoard.length; j++) {
                tBoard[j][i] += tBoard[j - 1][i];
            }
        }
    }
    
    private int cntStandingBuildings(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + tBoard[i][j] > 0) cnt++;
            }
        }
        
        return cnt;
    }
}



// 각 스킬이 사용될 때마다 일일이 보드를 갱신하면 효율성이 떨어진다

// class Solution {
//     public int solution(int[][] board, int[][] skills) {
//         int[][] board2 = new int[board.length][board[0].length];
        
//         for (int[] skill : skills) {
//             int sign = (skill[0] == 1)? -1 : 1;
//             for (int i = skill[1]; i <= skill[3]; i++) {
//                 for (int j = skill[2]; j <= skill[4]; j++) {
//                     board[i][j] +=  sign * skill[5];
//                 }
//             }
//         }
        
//         return checkBoard(board);
//     }
    
//     private int checkBoard(int[][] board) {
//         int cnt = 0;
//         for (int[] row : board) {
//             for (int num : row) if (num > 0) cnt++;
//         }
        
//         return cnt;
//     }
// }