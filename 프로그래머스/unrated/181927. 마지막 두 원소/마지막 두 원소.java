import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.copyOfRange(num_list, 0, num_list.length + 1);
        int lastNum = num_list[num_list.length - 1];
        int secLastNum = num_list[num_list.length - 2];
        answer[answer.length - 1] = (lastNum > secLastNum)? lastNum - secLastNum : lastNum * 2;
        
        return answer;
    }
}