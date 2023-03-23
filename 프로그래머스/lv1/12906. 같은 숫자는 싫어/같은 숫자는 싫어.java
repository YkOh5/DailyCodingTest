// 1. 주어진 배열의 각 원소들을 Stack에 옮겨 담으면서, Stack.peek()를 이용해 연속적으로 나타나는 숫자들을 제거
// 2. Stack은 후입선출의 구조이므로, Stack에서 꺼낸 각 원소들을 역순으로 배열에 추가한 후 반환

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        // 주어진 배열의 모든 원소들에 대해서
        for (int item : arr) {
            // Stack이 비어있지 않고, 해당 원소가 Stack의 마지막 원소와 같은 경우
            if (!stack.isEmpty() && stack.peek() == item) {
                continue;   // 아래의 코드를 실행하지 않고 건너뛴다
            }            
            stack.add(item);   // 해당 원소를 Stack에 추가
        }
        
        int[] answer = new int[stack.size()];
        // 정수형 배열에 역순으로
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();   // Stack에서 꺼낸 원소들을 추가
        }
        
        return answer;
    }
}



// 아래와 같이 불필요하게 ArrayList를 사용한 코드는 효율성 테스트를 통과하지 못 했다
// public class Solution {
//     public Integer[] solution(int []arr) {
//         Stack<Integer> stack = new Stack<>();
//         // 주어진 배열의 각 원소들에 대해
//         for (int item : arr) {
//             // Stack이 비어있는 경우
//             if (stack.isEmpty()) {
//                 stack.add(item);   // 해당 원소를 Stack에 추가
//             // Stack이 비어있지 않고, Stack의 마지막 원소가 배열의 해당 원소와 일치하지 않은 경우
//             } else if (stack.peek() != item) {
//                 stack.add(item);   // 해당 원소를 Stack에 추가
//             }            
//         }                
//         ArrayList<Integer> arrList = new ArrayList<>();
//         // Stack이 빌 때까지
//         while (!stack.isEmpty()) {
//             int num = stack.pop();   // Stack에서 꺼낸 원소를
//             arrList.add(0, num);   // ArrayList의 0번째 인덱스에 추가
//         }        
//         // ArrayList를 배열로 변환해서 반환
//         return arrList.toArray(new Integer[arrList.size()]);
//     }
// }