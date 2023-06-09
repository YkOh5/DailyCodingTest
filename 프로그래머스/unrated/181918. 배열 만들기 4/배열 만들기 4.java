import java.util.Stack;
import java.util.Vector;

class Solution {
    public Integer[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) stack.push(arr[i]);
            else {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
                stack.push(arr[i]);
            }
        }
        
        return new Vector<>(stack).toArray(new Integer[0]);
    }
}