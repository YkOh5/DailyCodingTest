import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        HashMap<ArrayList<String>, ArrayList<Integer>> infoMap = new HashMap<>();
        for (String i : info) {
            ArrayList<String> appInfo = new ArrayList<>(Arrays.asList(i.split(" ")));
            int score = Integer.parseInt(appInfo.remove(appInfo.size() - 1));            
            
            ArrayList<Integer> scores = infoMap.getOrDefault(appInfo, new ArrayList<>());
            scores.add(score);
            infoMap.put(appInfo, scores);
        }
        
        for (ArrayList<String> key : infoMap.keySet()) {            
            Collections.sort(infoMap.get(key));            
        }
        
        for (int i = 0; i < query.length; i++) {            
            ArrayList<String> appCondition = new ArrayList<>();
            for (String str : query[i].split(" and | ")) {
                if (!str.equals("-")) appCondition.add(str);
            }
            
            int cutline = Integer.parseInt(appCondition.remove(appCondition.size() - 1));
            int cnt = 0;
            
            for (ArrayList<String> key : infoMap.keySet()) {
                if (!key.containsAll(appCondition)) continue;
                
                ArrayList<Integer> scores = infoMap.get(key);
                cnt += countAboveCutline(scores, cutline);
            }
            
            answer[i] = cnt;
        }
                
        return answer;
    }
    
    private int countAboveCutline(ArrayList<Integer> scores, int cutline) {
        int left = 0;
        int right = scores.size()- 1;
        int mid;
        
        while (left <= right) {
            mid = (left + right) / 2;
            
            if (cutline <= scores.get(mid)) right = mid - 1;
            else left = mid + 1;
        }
        
        return scores.size() - left;
    }
}