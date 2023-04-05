import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        // 중복되는 값을 배제하기 위해 HashSet을 이용
        HashSet<Integer> set = new HashSet<>();
        // 서로 다른 인덱스의 두 원소를 더한 값을 HashSet에 추가
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        // 정답을 반환하기 위한 배열
        int[] answer = new int[set.size()];
        int idx = 0;   // 배열의 인덱스
        // HashSet의 원소들을 배열에 추가
        for (Integer item : set) {
            answer[idx++] = item;
        }
        // 오름차순으로 정렬
        Arrays.sort(answer);
        
        return answer;
        
        
        // HashSet에 값을 추가한 이후의 코드들은 아래와 같이 단 한 줄로 줄일 수 있으나, 처리속도가 느려진다
        // return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
