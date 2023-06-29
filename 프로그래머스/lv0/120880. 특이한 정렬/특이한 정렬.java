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
    
    if (diff1 == diff2) {
        // 절대값이 같을 때 크기가 더 큰 수가 앞에 오도록 비교
        return num2 - num1;
    } else {
        // 절대값이 다를 때 기존의 비교 방식 사용
        return diff1 - diff2;
    }
});

        
        return answer;
    }
}
