class Solution {
    private char[][] board;
    private boolean[][] checked;
    private int[] di = {0, 1, 0, 1};
    private int[] dj = {0, 0, 1, 1};
    private int removedBlockCnt = 0;
    private boolean removed;
    
    public int solution(int m, int n, String[] board) {
        this.board = new char[m][n];
        for (int i = 0; i < m; i++) {
            this.board[i] = board[i].toCharArray();
        }
        
        searchBoard();
        
        return removedBlockCnt;
    }
    
    private void searchBoard() {
        checked = new boolean[board.length][board[0].length];
        removed = false;
        
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[i][j] == ' ') continue;
                
                boolean sameBlocks = true;
                for (int k = 1; k < di.length; k++) {
                    if (board[i][j] != board[i + di[k]][j + dj[k]]) {
                        sameBlocks = false;
                        break;
                    }
                }
                
                if (sameBlocks) {
                    for (int k = 0; k < di.length; k++) {
                        checkBlock(i + di[k], j + dj[k]);
                    }
                    removed = true;
                }
            }
        }
        
        if (removed) {
            updateBoard();
            searchBoard();
        }
    }
    
    private void checkBlock(int x, int y) {
        if (!checked[x][y]) {
            checked[x][y] = true;
            removedBlockCnt++;
        }
    }
    
    private void updateBoard() {
        for (int i = 0; i < board[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = board.length - 1; j >= 0; j--) {
                if (!checked[j][i]) sb.append(board[j][i]);
            }
                        
            int idx = 0;
            for (int j = board.length - 1; j >= 0; j--) {
                if (idx < sb.length()) board[j][i] = sb.charAt(idx);
                else board[j][i] = ' ';
                idx++;
            }
        }
    }
}