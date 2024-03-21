import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> cntMap1 = new HashMap<>();
        HashMap<Integer, Integer> cntMap2 = new HashMap<>();
        
        for (int[] edge : edges) {
            cntMap1.put(edge[0], cntMap1.getOrDefault(edge[0], 0) + 1);
            cntMap2.put(edge[1], cntMap2.getOrDefault(edge[1], 0) + 1);
        }
        
        int[] answer = new int[4];
        
        for (int key : cntMap1.keySet()) {
            if (cntMap1.get(key) >= 2 && !cntMap2.containsKey(key)) answer[0] = key;
            if (cntMap1.get(key) == 2 && cntMap2.getOrDefault(key, 0) >= 2) answer[3]++;
        }
        
        for (int key : cntMap2.keySet()) {
            if (cntMap2.get(key) > 0 && !cntMap1.containsKey(key)) answer[2]++;
        }
        
        answer[1] = cntMap1.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}