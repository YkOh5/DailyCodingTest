// 1. 귤의 크기(key)와 크기별 개수(value)를 매핑하기 위해 HashMap을 이용
// 2. 귤의 크기별 개수(value)를 배열에 넣은 후 정렬
// 3. 배열의 원소들을 내림차순으로 더한 값이 상자에 담을 귤의 개수(k) 이상일 때까지의 인덱스 변화량을 반환

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤의 크기(key)와 크기별 개수(value)를 매핑
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : tangerine) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        // 귤의 크기별 개수(value)를 배열에 넣은 후 정렬
        Collection<Integer> values = map.values();
        Integer[] valArr = values.toArray(new Integer[0]);
        Arrays.sort(valArr);
        
        int sum = 0;
        int cnt = 0;
        
        // 배열의 원소들을 내림차순으로
        for (int i = valArr.length - 1; i >= 0; i--) {
            sum += valArr[i];
            cnt++;
            // 더한 값이 상자에 담을 귤의 개수(k) 이상일 때
            if (sum >= k) {
                break;
            }
        }
        
        // 인덱스 변화량을 반환
        return cnt;
    }
}