class Solution {
    public int solution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) detectHazardZone(board, i, j);
            }
        }
        
        return countSafeZone(board);
    }
    
    private void detectHazardZone(int[][] board, int i, int j) {
        int[] distance = {-1, 0, 1};
        
        for (int di : distance) {
            for (int dj : distance) {
                if (isInTheBoard(board, i, j, di, dj) && board[i + di][j + dj] == 0) 
                    board[i + di][j + dj] = 2;
            }
        }
    }
    
    private boolean isInTheBoard(int[][] board, int i, int j, int di, int dj) {
        if (0 <= i + di && i +di < board.length && 0 <= j + dj && j + dj < board[i].length) return true;
        
        return false;
    }
    
    private int countSafeZone(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        
        return cnt;
    }
}