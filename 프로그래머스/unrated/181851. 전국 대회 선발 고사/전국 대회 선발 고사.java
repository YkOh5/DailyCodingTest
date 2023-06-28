import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<int[]> validRankList = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) validRankList.add(new int[]{rank[i], i});
        }
        
        Collections.sort(validRankList, (a, b) -> (a[0] - b[0]));
                
        return 10000 * validRankList.get(0)[1] + 100 * validRankList.get(1)[1] + validRankList.get(2)[1];
    }
}