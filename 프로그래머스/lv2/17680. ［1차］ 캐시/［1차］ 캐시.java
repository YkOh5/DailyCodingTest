// 조건에 따라 구현하기 위해서는 자료의 순서를 따져야 하고, 특정 위치의 자료를 곧바로 삭제할 수 있는 자료구조가 필요하므로
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
                latency++;
            } else if (cache.size() == cacheSize) {
                cache.remove(0);
                latency += 5;
            } else latency += 5;
            
            cache.add(entry);
        }
        
        return latency;
    }
}