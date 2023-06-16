class Solution {
    private int x = 0;
    private int y = 0;
    
    public int[] solution(String[] keys, int[] board) {        
        for (String key : keys) {
            switch (key) {
                case "up" -> y = (Math.abs(y + 1) <= board[1] / 2)? y + 1 : y;
                case "down" -> y = (Math.abs(y - 1) <= board[1] / 2)? y - 1 : y;
                case "left" -> x = (Math.abs(x - 1) <= board[0] / 2)? x - 1 : x;
                case "right" -> x = (Math.abs(x + 1) <= board[0] / 2)? x + 1 : x;
            }
        }
                
        return new int[]{x, y};
    }
}