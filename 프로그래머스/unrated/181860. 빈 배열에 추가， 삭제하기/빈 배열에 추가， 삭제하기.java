import java.util.Stack;

class Solution {
    public Integer[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    stack.push(arr[i]);
                }
            } else {
                for (int k = 0; k < arr[i]; k++) {
                    stack.pop();
                }
            }        
        }
        
        return stack.toArray(new Integer[0]);
    }
}