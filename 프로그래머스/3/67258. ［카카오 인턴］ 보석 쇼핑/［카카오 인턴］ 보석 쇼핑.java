import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, Integer.MAX_VALUE};        
        HashSet<String> fullGemSet = new HashSet<>();
        
        for (String gem : gems) {
            fullGemSet.add(gem);
        }        
                
        HashMap<String, Integer> gemCntMap = new HashMap<>();
        HashSet<String> curGemSet = new HashSet<>();
        
        int fullSetSize = fullGemSet.size();
        int p1 = 0, p2 = -1;
        
        while(p1 < gems.length - fullSetSize || p2 < gems.length - 1) {
            if (curGemSet.size() < fullSetSize && p2 < gems.length - 1) {
                p2++;
                gemCntMap.put(gems[p2], gemCntMap.getOrDefault(gems[p2], 0) + 1);
                curGemSet.add(gems[p2]);
            } else {
                p1++;
                gemCntMap.put(gems[p1 - 1], gemCntMap.getOrDefault(gems[p1 - 1], 0) - 1);
                if (gemCntMap.get(gems[p1 - 1]) == 0) curGemSet.remove(gems[p1 - 1]);
            } 
            
            if (curGemSet.size() == fullSetSize && p2 - p1 < answer[1] - answer[0]) {
                answer[0] = p1 + 1;
                answer[1] = p2 + 1;
            }
        }
        
        return answer;
    }
}