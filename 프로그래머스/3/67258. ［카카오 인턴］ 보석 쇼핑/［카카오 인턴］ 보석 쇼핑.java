import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];        
        HashSet<String> fullGemSet = new HashSet<>();
        HashMap<String, Integer> gemMap = new HashMap<>();
        
        for (String gem : gems) {
            fullGemSet.add(gem);
        }
                
        HashSet<String> curGemSet = new HashSet<>();        
        int fullSetSize = fullGemSet.size();
        int minRange = Integer.MAX_VALUE;
        int p1 = 0, p2 = -1;
        
        while(p1 < gems.length - fullSetSize || p2 < gems.length - 1) {
            if (curGemSet.size() >= fullSetSize || p2 == gems.length - 1) {
                p1++;
                gemMap.put(gems[p1 - 1], gemMap.getOrDefault(gems[p1 - 1], 0) - 1);
                if (gemMap.get(gems[p1 - 1]) == 0) curGemSet.remove(gems[p1 - 1]);
            } else if (curGemSet.size() < fullSetSize) {
                p2++;
                gemMap.put(gems[p2], gemMap.getOrDefault(gems[p2], 0) + 1);
                curGemSet.add(gems[p2]);
            }
            
            if (curGemSet.size() == fullSetSize && p2 - p1 < minRange) {
                minRange = p2 - p1;
                answer[0] = p1 + 1;
                answer[1] = p2 + 1;
            }
        }
        
        return answer;
    }
}