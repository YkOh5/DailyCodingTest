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



// HashMap을 이용한 풀이
// import java.util.Arrays;
// import java.util.HashMap;
// class Solution {
//     public int solution(int[] rank, boolean[] attendance) {
//         HashMap<Integer, Integer> rankMap = new HashMap<>();
//         for (int idx = 0; idx < rank.length; idx++) {
//             if (attendance[idx]) rankMap.put(rank[idx], idx);
//         }
//         Arrays.sort(rank);
//         int coefficient = 10000;
//         int answer = 0;
//         int cnt = 0;
//         for (int idx = 0; idx < rank.length; idx++) {
//             if (rankMap.containsKey(rank[idx])) {
//                 answer += rankMap.get(rank[idx]) * coefficient;
//                 coefficient /= 100;
//             }
//             if (cnt == 3) break;
//         }
//         return answer;
//     }
// }