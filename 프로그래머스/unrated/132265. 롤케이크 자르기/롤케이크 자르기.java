// 1. 토핑의 종류와 개수를 매핑하기 위해 HashMap을 이용
// 2. 모든 토핑을 철수(map1)가 가진 상태에서 토핑을 하나씩 동생(map2)에게로 넘겨주며
// 3. 서로가 가진 토핑 종류의 개수(map.keySet().size())가 같을 때마다 반환값 + 1

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 토핑의 종류와 개수를 매핑하기 위해 HashMap을 이용
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        // 모든 토핑을 철수가 가진 상태
        for (int i = 0; i < topping.length; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
        }
        
        int cnt = 0;        
        
        // 철수가 가진 토핑을 하나씩 동생에게 양도
        for (int i = 0; i < topping.length; i++) {
            // 서로가 가진 토핑의 종류가 같을 때
            if (map1.keySet().size() == map2.keySet().size()) {
                cnt++;
            }
            
            // 철수가 가진 해당 토핑의 개수가 1개 이하이면 매핑된 값을 제거
            if (map1.get(topping[i]) <= 1) {
                map1.remove(topping[i]);
            } else {
                map1.put(topping[i], map1.get(topping[i]) - 1);                
            }
            
            map2.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
        }       
        
        return cnt;
    }
}