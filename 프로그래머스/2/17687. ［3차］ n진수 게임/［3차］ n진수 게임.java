import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {        
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] alphabets = {"A", "B", "C", "D", "E", "F"};
        StringBuilder nums = new StringBuilder().append(0);
        StringBuilder tube = new StringBuilder();
        
        while (true) {
            map.put(0, map.getOrDefault(0, 0) + 1);            
            for (int key : map.keySet()) {                
                if (map.getOrDefault(key, 0) >= n) {
                    map.put(key + 1, map.getOrDefault(key + 1, 0) + 1);
                    map.put(key, 0);
                }
            }            
            
            StringBuilder sb = new StringBuilder();            
            for (int key : map.keySet()) {
                String str;
                
                if (map.get(key) >= 10) str = alphabets[map.get(key) - 10];
                else str = String.valueOf(map.get(key));
                
                sb.insert(0, str);
            }
            
            nums.append(sb.toString());
            
            if (nums.length() >= (t - 1) * m + p) break;
        }
        
        for (int i = p - 1; i < nums.length(); i += m) {
            tube.append(nums.charAt(i));
            
            if (tube.length() == t) break;
        }
        
        return tube.toString();
    }
}