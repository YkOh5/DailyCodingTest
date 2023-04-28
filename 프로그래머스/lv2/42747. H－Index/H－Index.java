import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = Math.min(citations.length, citations[citations.length - 1]);
        for (int i = h; i >= 0; i--) {
            if (i >= 1 && citations[citations.length - i] < i) continue;
            if (citations.length - i - 1 >= 0 && citations[citations.length - i - 1] > i) continue;
            return i;
        }
        
        return -1;
    }
}