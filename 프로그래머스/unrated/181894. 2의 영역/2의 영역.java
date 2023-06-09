import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int startIdx = -1;
        int endIdx = -1;
        boolean contains2 = false;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                contains2 = true;
                if (startIdx == -1) {
                    startIdx = i;
                    endIdx = i;
                } else endIdx = i;
            }
        }
                        
        return (contains2)? Arrays.copyOfRange(arr, startIdx, endIdx + 1) : new int[]{-1};
    }
}