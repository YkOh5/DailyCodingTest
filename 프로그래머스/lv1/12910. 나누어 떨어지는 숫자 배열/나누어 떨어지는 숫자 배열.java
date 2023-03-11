import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // 주어진 조건에 맞는 원소들을 담기 위한 ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
        // arr의 원소들 중  
        for (int item : arr) {
            // divisor로 나눈 나머지가 0인 원소들을
            if (item % divisor == 0) {
                // ArrayList에 추가
                list.add(item);
            }
        }
        
        // divisor로 나눈 나머지가 0인 원소가 하나도 없다면 -1을 추가
        if (list.size() == 0) {
            list.add(-1);
        }
        
        // ArrayList를 오름차순으로 정렬
        Collections.sort(list);
        
        // ArrayList<Integer>를 언박싱한 후 배열로 변환해서 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}