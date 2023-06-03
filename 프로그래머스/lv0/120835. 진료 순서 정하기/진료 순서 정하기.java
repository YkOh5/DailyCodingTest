import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] emergency) {
        HashMap<Integer, Integer> emergencyMap = new HashMap<>();
        int[] levels = emergency.clone();
        Arrays.sort(levels);
        
        for (int i = 0; i < levels.length; i++) {
            emergencyMap.put(levels[i], levels.length - i);
        }
        
        for (int i = 0; i < emergency.length; i++) {
            emergency[i] = emergencyMap.get(emergency[i]);
        }
                
        return emergency;
    }
}