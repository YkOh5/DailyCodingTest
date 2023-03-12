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
        
        // ArrayList<Integer>를 정렬하고 언박싱한 후 배열로 변환해서 반환
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
        
                
        // Stream을 잘 쓰면 단 두 줄로도 풀 수 있는 문제였다...
        // int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();        
        // return answer.length == 0 ? new int[]{-1} : answer;
    }
}