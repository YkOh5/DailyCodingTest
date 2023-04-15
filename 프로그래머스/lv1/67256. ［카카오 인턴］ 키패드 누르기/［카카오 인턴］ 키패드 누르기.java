// 엄지손가락이 상하좌우 4가지 방향으로만 이동할 수 있으므로, 유클리드 거리가 아닌 맨하탄 거리를 사용해야 한다

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        // 각 숫자(= numPos의 index)들의 위치
        int[][] numPos = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2 ,0}, {2, 1}, {2, 2}};
        int[] leftPos = {3, 0};   // 왼손의 현재 위치
        int[] rightPos = {3, 2};   // 오른손의 현재 위치
        
        for (int num : numbers) {
            // 해당 숫자와 양손 사이의 맨하탄 거리
            int distanceL = Math.abs(leftPos[0] - numPos[num][0]) + Math.abs(leftPos[1] - numPos[num][1]);
            int distanceR = Math.abs(rightPos[0] - numPos[num][0]) + Math.abs(rightPos[1] - numPos[num][1]);
            
            switch (num) {
                case 1, 4, 7 -> { 
                    answer.append('L');
                    leftPos = numPos[num];
                }
                case 3, 6, 9 -> {
                    answer.append('R');
                    rightPos = numPos[num];
                }
                // 2, 5, 8, 0
                default -> {
                    if (distanceL < distanceR || (distanceL == distanceR && hand.equals("left"))) {
                        answer.append('L');
                        leftPos = numPos[num];
                    }
                    else {
                        answer.append('R');
                        rightPos = numPos[num];
                    }                    
                }
            }                    
        }
                
        return answer.toString();
    }
}