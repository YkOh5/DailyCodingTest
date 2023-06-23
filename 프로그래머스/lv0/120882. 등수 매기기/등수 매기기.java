import java.util.Arrays;
import java.util.HashMap;

class Solution {
    private HashMap<Double, Integer> meanMap = new HashMap<>();
    private HashMap<Double, Integer> rankMap = new HashMap<>();
    private double[] means;
    private double[] distinctMeans;
    
    public int[] solution(int[][] scores) {
        getMeanMap(scores);
        getRankMap(meanMap);
        
        int[] answer = new int[scores.length];
        for (int i = 0; i < means.length; i++) {
            answer[i] = rankMap.get(means[i]);
        }
        
        return answer;
    }
    
    private void getMeanMap(int[][] scores) {
        means = new double[scores.length];
        for (int idx = 0; idx < scores.length; idx++) {
            double sum = 0;
            for (int score : scores[idx]) {
                sum += score;
            }
            means[idx] = sum / 2;
            meanMap.put(means[idx], meanMap.getOrDefault(means[idx], 0) + 1);
        }
    }
    
    private void getRankMap(HashMap<Double, Integer> meanMap) {
        distinctMeans = new double[meanMap.keySet().size()];
        int idx = 0;
        for (Double key : meanMap.keySet()) {
            distinctMeans[idx++] = key;
        }
        Arrays.sort(distinctMeans);
        
        int sum = 1;
        rankMap.put(distinctMeans[distinctMeans.length - 1], 1);
        for (int i = distinctMeans.length - 2; i >= 0; i--) {
            sum += meanMap.getOrDefault(distinctMeans[i + 1], 0);
            rankMap.put(distinctMeans[i], sum);
        }
    }
}