// 1. 주가(=prices[i])가 떨어지지 않는 동안의 시점(i)을 Stack에 계속 push
// 2. 주가가 떨어질 경우, 하락 시점(=i + 1) - 현재 주가보다 높은 이전 주가들의 시점(Stack.pop())을 배열에 저장
// 3. 모든 주가들에 대해 1~2 과정을 반복
// 4. Stack이 소진될 때까지, 마지막 시점(prices.length-1) - 이전 주가들의 시점(Stack.pop())을 배열에 추가 후 반환

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 각 주가들의 시점을 기록하기 위한 자료구조
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int idx = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            // 주가가 떨어질 경우
            if (prices[i] > prices[i+1]) {
                answer[i] = 1;
                // 하락한 주가보다 높은 이전 주가들에 대해
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i+1]) {
                    idx = stack.pop();
                    // 하락 시점 - 이전 시점
                    answer[idx] = (i + 1) - idx;
                }                
            } else {
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()) {
            idx = stack.pop();
            // 마지막 시점 - 이전 주가들의 시점
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}