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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += tBoard[i][j];
            }
        }
        
        int cnt = 0;        
        for (int[] row : board) {
            for (int hp : row) if (hp > 0) cnt++;
        }
        
        return cnt;
    }
}