import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) idxList.add(i);
        }
        Collections.sort(idxList, (num1, num2) -> (rank[num1] - rank[num2]));
        
        return 10000 * idxList.get(0) + 100 * idxList.get(1) + idxList.get(2);
    }
}



// import java.util.ArrayList;
// import java.util.Collections;

// class Solution {
//     public int solution(int[] rank, boolean[] attendance) {
//         ArrayList<int[]> validRankList = new ArrayList<>();
//         for (int i = 0; i < rank.length; i++) {
//             if (attendance[i]) validRankList.add(new int[]{rank[i], i});
//         }
        
//         Collections.sort(validRankList, (a, b) -> (a[0] - b[0]));
                
//         return 10000 * validRankList.get(0)[1] + 100 * validRankList.get(1)[1] + validRankList.get(2)[1];
//     }
// }



// PriorityQueue를 이용한 풀이
// import java.util.PriorityQueue;
// class Solution {
//     public int solution(int[] rank, boolean[] attendance) {
//         PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> rank[a] - rank[b]);
//         for (int i = 0; i < attendance.length; i++) {
//             if (attendance[i])
//                 que.add(i);
//         }
//         return que.poll() * 10000 + que.poll() * 100 + que.poll();
//     }
// }



// Stream을 이용한 풀이
// import java.util.Comparator;
// import java.util.stream.IntStream;
// class Solution {
//     public int solution(int[] rank, boolean[] attendance) {
//         return IntStream.range(0, rank.length)
//                 .filter(i -> attendance[i])
//                 .boxed()
//                 .sorted(Comparator.comparing(i -> rank[i]))
//                 .limit(3L)
//                 .reduce((current, next) -> current * 100 + next)
//                 .get();
//     }
// }



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