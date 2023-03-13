// 1. 반복문으로 주어진 int 배열의 원소들 중 최소값의 인덱스를 찾으면서, 각 원소들을 ArrayList에 추가
// 2. ArrayList에서 최소값의 인덱스에 해당하는 원소를 제거
// 3. ArrayList의 크기가 0이면 원소가 -1 하나뿐인 int 배열을 반환, 그 외 경우는 ArrayList를 배열로 변환하여 반환

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        
        // 주어진 배열의 모든 원소들에 대해
        for (int i = 0; i < arr.length; i++) {
            // 해당 원소가 기존의 최소값보다 작으면
            if (arr[i] < min) {
                min = arr[i];   // 최소값 갱신
                minIdx = i;   // 최소값의 인덱스 갱신
            }
            // 해당 원소를 ArrayList에 추가
            list.add(arr[i]);            
        }
        // ArrayList에서 최소값의 인덱스에 위치한 원소를 제거
        list.remove(minIdx);
        
        // ArrayList의 크기가 0이면 원소가 -1 하나뿐인 int 배열을 반환
        // 그렇지 않으면 ArrayList<Integer>를 언박싱한 후 배열로 변환하여 반환
        return list.size() == 0? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
        
        
        // Stream을 잘 활용하면 단 두 줄의 코드로도 해결 가능
        // int min = Arrays.stream(arr).min().getAsInt();
        // return arr.length <= 1? new int[]{-1} : Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}