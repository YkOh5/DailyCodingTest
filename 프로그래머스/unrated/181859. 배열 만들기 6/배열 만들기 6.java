import java.util.Stack;

class Solution {
    public Integer[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() == arr[i]) stack.pop();
            else stack.add(arr[i]);
        }
        
        return (stack.isEmpty())? new Integer[]{-1} : stack.toArray(new Integer[0]);
    }
}