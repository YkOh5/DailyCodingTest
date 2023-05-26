import java.util.*;

class Solution {
        public int solution(int[] numbers) {

            // reverse sort
            numbers = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
            int answer = numbers[0] * numbers[1];
            return answer;
        }
    }