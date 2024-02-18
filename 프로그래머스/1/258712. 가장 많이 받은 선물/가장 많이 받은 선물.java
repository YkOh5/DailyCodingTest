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