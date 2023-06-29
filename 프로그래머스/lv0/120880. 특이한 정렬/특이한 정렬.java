import java.util.*;

class Solution {
    public Integer[] solution(int[] numlist, int n) {
        Integer[] answer = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            answer[i] = numlist[i];
        }
        
        Arrays.sort(answer, (num1, num2) -> {
            int diff1 = Math.abs(n - num1);
            int diff2 = Math.abs(n - num2);
            
            if (diff1 == diff2) return num2 - num1;
            else return diff1 - diff2;                                        
        });
        
        return answer;
    }
}
