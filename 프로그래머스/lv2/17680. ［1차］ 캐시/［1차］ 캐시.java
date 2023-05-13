// 조건에 따라 구현하기 위해서는 자료의 순서를 따져야 하고, 특정 위치의 자료를 삭제할 수 있는 자료구조가 필요하므로
// Queue가 아닌 ArrayList를 사용

import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        ArrayList<String> cache = new ArrayList<>();
        int latency = 0;
        
        for (String city : cities) {
            String entry = city.toLowerCase();
            
            if (cache.contains(entry)) {
                cache.remove(cache.indexOf(entry));
                cache.add(entry);
                latency++;
            } else {
                cache.add(entry);
                latency += 5;
            }
            
            if (cache.size() > cacheSize) cache.remove(0);
        }
        
        return latency;
    }
}