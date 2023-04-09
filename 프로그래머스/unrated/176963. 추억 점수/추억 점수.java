import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 그리운 사람들과 그리움 점수를 매핑
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        // 각 사진별 추억점수를 배열에 저장
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;   // 추억 점수 = 사진 속 인물들에 대한 그리움 점수의 합
            for (int j = 0; j < photo[i].length; j++) {
                // NullPointerException을 방지하기 위해 getOrDefault를 이용
                sum += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
                
        return answer;
    }
}