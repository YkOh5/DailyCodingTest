// 1. Stack을 이용해서 주어진 배열에 연속적으로 나타나는 숫자들을 제거
// 2. Stack에서 꺼낸 각 원소들을 ArrayList의 0번째 인덱스에 추가
// 3. ArrayList를 배열로 변환해서 반환

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int item : arr) {
            if (stack.isEmpty() || stack.peek() != item) {
                stack.add(item);
            }            
                        
        }
        
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}