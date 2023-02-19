import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        int cnt = 0;
        
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && cnt < k && stack.peek() - '0' < number.charAt(i) - '0') {
                stack.pop();
                cnt++;
            }
            
            if (stack.size() < number.length() - k) {
                stack.push(number.charAt(i));
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        
        return answer.toString();
    }
}