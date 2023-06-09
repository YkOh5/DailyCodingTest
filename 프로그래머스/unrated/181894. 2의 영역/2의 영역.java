import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int startIdx = 0;
        int endIdx = 0;
        boolean contains2 = false;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                contains2 = true;
                startIdx = i;
                break;
            }
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                contains2 = true;
                endIdx = i;
                break;
            }
        }
                
        return (contains2)? Arrays.copyOfRange(arr, startIdx, endIdx + 1) : new int[]{-1};
    }
}