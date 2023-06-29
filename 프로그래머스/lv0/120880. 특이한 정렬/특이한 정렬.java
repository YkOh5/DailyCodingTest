import java.util.Arrays;

class Solution {
    public Integer[] solution(int[] numlist, int n) {
        Integer[] answer = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            answer[i] = numlist[i];
        }
        
        Arrays.sort(answer, (num1, num2) -> {
            int diff1 = Math.abs(n - num1);
            int diff2 = Math.abs(n - num2);
            
            return (diff1 != diff2)? diff1 - diff2 : num2 - num1;
        });

        return answer;
    }
}