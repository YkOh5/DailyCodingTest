// 두 개의 지도 중 어느 하나라도 벽인 부분은 겹쳐진 전체 지도에서도 벽이므로, 암호화된 두 배열에 대해 OR 비트 연산자를 이용

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            // 암호화된 각 정수 배열에서 겹치는 부분끼리의 OR 비트 연산 결과를 2진수 문자열로 변환
            String row = Integer.toBinaryString(arr1[i] | arr2[i]);
            // 행을 나타내는 2진수 문자열을 지도의 길이에 맞게 배치하고 2진수 중 1은 벽(#)으로, 0은 공백( )으로 복구
            answer[i] = String.format("%" + n + "s", row).replace("1", "#").replace("0", " ");
            
            // 지도 최대 길이와 실제 길이를 고려해서 substring()을 사용하면 처리속도를 개선할 수 있다
            // answer[i] = String.format("%16s", row).substring(16-n).replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}
