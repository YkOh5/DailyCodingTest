// 1. 문자열의 문자가 닫는 괄호일 때, Stack이 비지 않았고 Stack의 마지막 원소가 여는 괄호이면 pop
// 2. Stack이 비었거나 Stack의 마지막 원소가 여는 괄호가 아니면 false 반환
// 3. 해당 문자가 여는 괄호일 때, push!
// 4. 반복문 종료 후 Stack이 비었으면 true, 비지 않았으면 false 반환

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }                
            } else {
                stack.push(s.charAt(i));
            }   
        }
        
        // 효율성 테스트 탈락 1 - String 클래스는 처리속도가 느리다(?)
        // for (String str: s.split("")) {
        //     if (str.equals(")")) {
        //         if (!stack.isEmpty() && stack.peek().equals("(")) {
        //             stack.pop();
        //         } else {
        //             return false;
        //         }                
        //     } else {
        //         stack.push(str);
        //     }            
        // }
        
        // 효율성 테스트 탈락 2 - String 클래스는 처리속도가 느리다(?)
        // for (String str: s.split("")) {
        //     if (str.equals("(")) {
        //         stack.push(str);                
        //     } else if (stack.isEmpty()) {
        //         return false;
        //     } else {
        //         stack.pop();
        //     }
        // }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}