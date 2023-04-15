import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    // 바구니가 비어있지 않고, 바구니의 가장 위에 있는 인형이 담으려는 인형과 같은 인형일 때
                    if (!basket.isEmpty() && basket.peek() == board[j][moves[i] - 1]) {
                        basket.pop();
                        answer += 2;   // 터트려져 사라진 인형의 개수 + 2
                    } else {
                        basket.push(board[j][moves[i] - 1]);
                    }
                    
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}