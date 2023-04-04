import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        
        for (Integer item : set) {
            answer[idx++] = item;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}