import java.util.*;

class Solution {
    public String solution(String parentheses) {
        
        return getValidParentheses(parentheses);
    }
    
    private String getValidParentheses(String parentheses) {
        StringBuilder sb = new StringBuilder();
        StringBuilder u = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        
        for (int i = 0; i < parentheses.length(); i++) {
            char parenthesis = parentheses.charAt(i);
            u.append(parenthesis);
            
            if (parenthesis == '(') {
                cnt++;
                stack.push(parenthesis);
            } else {
                cnt--;
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(parenthesis);
            }
            
            if (cnt == 0 && stack.isEmpty()) {
                sb.append(u);
                if (i < parentheses.length() - 1)
                    sb.append(getValidParentheses(parentheses.substring(i + 1)));
                break;
            } else if (cnt == 0 && !stack.isEmpty()) {
                sb.append('(');
                if (i < parentheses.length() - 1)
                    sb.append(getValidParentheses(parentheses.substring(i + 1)));
                sb.append(')');
                for (int j = 1; j < u.length() - 1; j++) {
                    if (u.charAt(j) == '(') sb.append(')');
                    else sb.append('(');
                }                
                break;
            }
        }
        
        return sb.toString();
    }
}


// 스택을 이용해서 올바른 괄호 문자열인지 확인하는 것보다 괄호의 개수를 직접 세는 편이 처리속도가 더 빠르다
// public static boolean isValidParentheses(String parenthesis) {    
//     int cnt = 0;
//     for(int i = 0; i < parenthesis.length(); i++) {        
//         if(parenthesis.charAt(i) == '(') {
//             cnt++;
//         } else {
//             cnt--;
//         }
        
//         if(cnt < 0) return false;
//     }
    
//     return true;
// }