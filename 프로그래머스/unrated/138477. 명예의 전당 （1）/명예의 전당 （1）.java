// 새로운 데이터를 매번 추가해야 하고, 기존의 데이터들과 값의 크기를 비교해야 하므로 ArrayList를 이용

import java.util.ArrayList;

class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> hallOfFame = new ArrayList<>();   
        int[] answer = new int[score.length];
        int targetIdx = 0;   // 당일에 출연한 가수의 점수가 위치할 인덱스
        
        hallOfFame.add(score[0]);   
        answer[0] = score[0];
        
        for (int i = 1; i < score.length; i++) {
            for (int j = 0; j < hallOfFame.size(); j++) {
                targetIdx = hallOfFame.size();
                // 새로운 점수가 특정 인덱스에 위치한 기존의 점수보다 작으면
                if (score[i] < hallOfFame.get(j)) {
                    targetIdx = j;   // 해당 인덱스에 새로운 점수를 추가
                    break;
                }
            }
            
            hallOfFame.add(targetIdx, score[i]);
            // 명예의 전당에 올려진 점수의 개수가 k개를 초과하면
            if (hallOfFame.size() > k) {
                hallOfFame.remove(0);   // 최하위 점수 탈락
            }
            
            answer[i] = hallOfFame.get(0);   // 상위 k번째 이내의 최하위 점수 발표
        }
        
        return answer;
    }
}



// Stack을 이용한 풀이
// import java.util.Stack;

// class Solution {
//     public int[] solution(int k, int[] score) {
//         Stack<Integer> HallOfFame = new Stack<>();
//         Stack<Integer> tmp = new Stack<>();
//         int[] answer = new int[score.length];
        
//         for (int i = 0; i < score.length; i++) {
//             while (!HallOfFame.isEmpty() && HallOfFame.peek() < score[i]) {
//                 tmp.push(HallOfFame.pop());
//             }
            
//             if (HallOfFame.size() < k) HallOfFame.push(score[i]);
            
//             while (HallOfFame.size() < k && !tmp.isEmpty()) {
//                 HallOfFame.push(tmp.pop());
//             }
            
//             tmp.clear();
            
//             answer[i] = HallOfFame.peek();
//         }
        
//         return answer;
//     }
// }
