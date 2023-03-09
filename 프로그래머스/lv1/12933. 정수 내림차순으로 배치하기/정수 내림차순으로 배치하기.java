import java.util.*;

class Solution {
    public long solution(long n) {
        String[] strArr = Long.toString(n).split("");
        Arrays.sort(strArr, Collections.reverseOrder());
        return Long.parseLong(String.join("", strArr));
    }
}