import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];     
        for (int n = 0; n < commands.length; n++) {
            // 배열 array의 i~j번째 숫자를 잘라낸 배열
            int[] subArray = Arrays.copyOfRange(array, commands[n][0]-1, commands[n][1]);
            // 잘라낸 배열을 오름차순으로 정렬
            Arrays.sort(subArray);
            // 정렬된 배열의 k번째 수
            answer[n] = subArray[commands[n][2]-1];
        }
        
        return answer;
    }
}