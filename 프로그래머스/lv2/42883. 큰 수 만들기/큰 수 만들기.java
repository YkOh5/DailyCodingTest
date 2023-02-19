// 1. 문자열의 숫자들을 하나씩 Stack에 push (문자열의 길이 - k개까지)
// 2. Stack에 들어있던 숫자들이 집어넣을 숫자보다 작으면 pop (k개까지)
// 3. StringBuilder.insert()를 이용하여 역순으로 이어붙여서 반환
    
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        int cnt = 0;
        
        for (int i = 0; i < number.length(); i++) {
            // k개까지 제거
            while (!stack.isEmpty() && cnt < k && stack.peek() - '0' < number.charAt(i) - '0') {
                stack.pop();
                cnt++;
            }
            
            // 문자열의 길이 - k개까지 추가
            if (stack.size() < number.length() - k) {
                stack.push(number.charAt(i));
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        // 역순으로 이어붙이기
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        
        return answer.toString();
    }
}