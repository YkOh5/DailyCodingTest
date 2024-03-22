import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> outCntMap = new HashMap<>();
        HashMap<Integer, Integer> inCntMap = new HashMap<>();
        
        for (int[] edge : edges) {
            outCntMap.put(edge[0], outCntMap.getOrDefault(edge[0], 0) + 1);
            inCntMap.put(edge[1], inCntMap.getOrDefault(edge[1], 0) + 1);
        }
        
        int[] answer = new int[4];
        
        for (int key : outCntMap.keySet()) {
            if (outCntMap.get(key) >= 2 && !inCntMap.containsKey(key)) answer[0] = key;
            if (outCntMap.get(key) == 2 && inCntMap.getOrDefault(key, 0) >= 2) answer[3]++;
        }
        
        for (int key : inCntMap.keySet()) {
            if (inCntMap.get(key) > 0 && !outCntMap.containsKey(key)) answer[2]++;
        }
        
        answer[1] = outCntMap.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}