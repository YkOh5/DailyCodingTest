// 1. 재료들을 주어진 순서대로 Stack에 push
// 2. 재료들이 햄버거를 만들기 위한 올바른 순서대로 쌓였을 때 해당 재료들을 pop
// 3. 순서에 맞지 않은 재료가 등장헸을 때 pop한 재료들을 다시 push 후 1의 과정으로 복귀
// 4. pop한 재료들이 햄버거를 만들기 위한 조합을 충족한다면 반환값 + 1
// 5. 재료가 모두 소진될 때까지 1~4과정을 반복

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        
        int cnt = 0;
        
        // 주어진 재료들에 대해서
        for (int i = 0; i < ingredient.length; i++) {
            // 해당 재료가 빵이고, 가장 위에 쌓여있는 재료가 고기일 때
            if (!stack.isEmpty() && ingredient[i] == 1 && stack.peek() == 3) {
                stack.pop();
                // 고기 아래에 쌓인 재료가 야채일 때
                if (!stack.isEmpty() && stack.peek() == 2) {
                    stack.pop();
                    // 야채 아래에 쌓인 재료가 빵일 때
                    if (!stack.isEmpty() && stack.peek() == 1) {
                        stack.pop();                        
                        cnt++;   // 포장할 햄버거 1개 증가
                    // 야채 아래에 쌓인 재료가 빵이 아닐 때
                    } else {
                        stack.push(2);
                        stack.push(3);
                        stack.push(1);
                    }
                // 고기 아래에 쌓인 재료가 야채가 아닐 때
                } else {
                    stack.push(3);
                    stack.push(1);
                }
            // 해당 재료가 빵이 아니거나 가장 위에 쌓여있는 재료가 고기가 아닐 때
            } else {
                stack.push(ingredient[i]);
            }
        }
        
        return cnt;
    }
}