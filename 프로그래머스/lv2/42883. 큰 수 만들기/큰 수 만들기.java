import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int max = 0;

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = idx; j <= k + i; j++) {
                int num = number.charAt(j) - '0';
                if (max < num) {
                    max = num;
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}




