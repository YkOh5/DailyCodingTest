class Solution {
    private int x = 0;
    private int y = 0;
    private int limitX, limitY;
    
    public int[] solution(String[] keys, int[] board) {
        limitX = (board[0] - 1) / 2;
        limitY = (board[1] - 1) / 2;
        
        for (String key : keys) {
            switch (key) {
                case "up" -> y = (Math.abs(y + 1) <= limitY)? y + 1 : y;
                case "down" -> y = (Math.abs(y - 1) <= limitY)? y - 1 : y;
                case "left" -> x = (Math.abs(x - 1) <= limitX)? x - 1 : x;
                case "right" -> x = (Math.abs(x + 1) <= limitX)? x + 1 : x;
            }
        }
                
        return new int[]{x, y};
    }
}