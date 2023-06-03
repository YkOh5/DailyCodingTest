import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        int num = numLog[0];
        StringBuffer sb = new StringBuffer();

        for (int i = 1;i < numLog.length;i++) {
            if (numLog[i] - num == 1) sb.append("w");
            else if (numLog[i] - num == -1) sb.append("s");
            else if (numLog[i] - num == 10) sb.append("d");
            else sb.append("a");
            num = numLog[i];
        }

        return sb.toString();
    }
}