import java.util.HashSet;

class Solution {
    public int solution(int[][] lines) {
        HashSet<Integer> commonIntervalSet = new HashSet<>();
        for (int i = 0; i < lines.length - 1; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                int start = Math.max(lines[i][0], lines[j][0]);
                int end = Math.min(lines[i][1], lines[j][1]);
                if (start < end) {
                    for (int k = start; k < end; k++) commonIntervalSet.add(k);
                }
            }
        }
        
        return commonIntervalSet.size();
    }
}