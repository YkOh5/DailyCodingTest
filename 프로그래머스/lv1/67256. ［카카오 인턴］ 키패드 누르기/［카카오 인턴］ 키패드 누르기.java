// 엄지손가락이 상하좌우 4가지 방향으로만 이동할 수 있으므로, 유클리드 거리가 아닌 맨하탄 거리를 사용해야 한다

class Solution {
    private StringBuilder answer = new StringBuilder();
    // 각 숫자(= numPos의 index)들의 위치
    private int[][] numPos = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2 ,0}, {2, 1}, {2, 2}};
    private int[] leftPos = {3, 0};   // 왼손의 현재 위치
    private int[] rightPos = {3, 2};   // 오른손의 현재 위치
    
    public String solution(int[] numbers, String hand) {
        for (int num : numbers) {
            // 해당 숫자와 양손 사이의 맨하탄 거리
            int distanceL = getManhattanDistance(leftPos, numPos[num]);
            int distanceR = getManhattanDistance(rightPos, numPos[num]);
                        
            switch (num) {
                case 1, 4, 7 -> { 
                    tappedWithTheLeftThumb(numPos[num]);
                }
                case 3, 6, 9 -> {
                    tappedWithTheRightThumb(numPos[num]);
                }
                // 2, 5, 8, 0
                default -> {
                    if (distanceL < distanceR || (distanceL == distanceR && hand.equals("left"))) {
                        tappedWithTheLeftThumb(numPos[num]);
                    }
                    else {
                        tappedWithTheRightThumb(numPos[num]);
                    }                    
                }
            }                    
        }
                
        return answer.toString();
    }
    
    private int getManhattanDistance(int[] thumbPos, int[] numPos) {
                return Math.abs(thumbPos[0] - numPos[0]) + Math.abs(thumbPos[1] - numPos[1]);
    }
    
    private void tappedWithTheLeftThumb(int[] numPos) {        
        answer.append('L');
        leftPos = numPos;                
    }
    
    private void tappedWithTheRightThumb(int[] numPos) {
        answer.append('R');
        rightPos = numPos;        
    }
}