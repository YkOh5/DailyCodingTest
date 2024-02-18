import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> giverTakerMap= new HashMap<>();
        HashMap<String, Integer> giftIndexMap = new HashMap<>();

        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift, " ");
            String giver = st.nextToken();
            String taker = st.nextToken();

            giverTakerMap.put(gift, giverTakerMap.getOrDefault(gift, 0) + 1);
            giftIndexMap.put(giver, giftIndexMap.getOrDefault(giver, 0) + 1);
            giftIndexMap.put(taker, giftIndexMap.getOrDefault(taker, 0) - 1);
        }

        int maxNextMonthGiftCnt = Integer.MIN_VALUE;

        for (int i = 0; i < friends.length; i++) {
            int nextMonthGiftCnt = 0;

            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;

                int giveCnt = giverTakerMap.getOrDefault(new StringBuilder().append(friends[i]).append(" ").append(friends[j]).toString(), 0);
                int takeCnt = giverTakerMap.getOrDefault(new StringBuilder().append(friends[j]).append(" ").append(friends[i]).toString(), 0);

                if (giveCnt > takeCnt) nextMonthGiftCnt++;
                else if (giveCnt == takeCnt && giftIndexMap.getOrDefault(friends[i], 0) > giftIndexMap.getOrDefault(friends[j], 0)) nextMonthGiftCnt++;
            }

            maxNextMonthGiftCnt = Math.max(maxNextMonthGiftCnt, nextMonthGiftCnt);
        }

        return maxNextMonthGiftCnt;
    }
}



// 아래의 코드처럼 친구들 개개인의 인덱스를 매핑한 후
// 개인별 인덱스를 이차원배열의 인덱스로 활용하면 더 직관적이고 효율적으로 구현 가능
// import java.util.*;

// class Solution {
//     public int solution(String[] friends, String[] gifts) {
//         Map<String, Integer> map = new HashMap<>();
//         for (int i = 0; i < friends.length; i++) {
//             map.put(friends[i], i);
//         }
//         int[] index = new int[friends.length];
//         int[][] record = new int[friends.length][friends.length];

//         for (String str : gifts) {
//             String[] cur = str.split(" ");
//             index[map.get(cur[0])]++;
//             index[map.get(cur[1])]--;
//             record[map.get(cur[0])][map.get(cur[1])]++;
//         }

//        int ans = 0;
//        for (int i = 0; i < friends.length; i++) {
//            int cnt = 0;
//            for (int j = 0; j < friends.length; j++) {
//                if(i == j) continue;
//                if (record[i][j] > record[j][i]) cnt++;
//                else if (record[i][j] == record[j][i] && index[i] > index[j]) cnt++; 
//            }
//            ans = Math.max(cnt, ans);
//        }
//         return ans;
//     }
// }