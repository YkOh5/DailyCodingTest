class Solution {
    public int solution(String s) {
        int cntSame = 0, cntDiff = 0;   // 첫 문자와 같거나 다른 문자의 개수
        int targetIdx = 0;   // 분리되고 남은 문자열의 첫 번째 인덱스
        int answer = 0;   // 분해한 문자열의 개수
        
        // 주어진 문자열의 모든 문자에 대해서
        for (int i = 0; i < s.length(); i++) {
            // 해당 문자가 분리되고 남은 문자열의 첫 번째 문자와 같은 경우
            if (s.charAt(i) == s.charAt(targetIdx)) cntSame++;
            // 다른 경우
            else cntDiff++;
            
            // 첫 문자와 같은 문자의 개수가 다른 문자와 개수와 같을 때
            if (cntSame == cntDiff) {
                answer++;   // 분해한 문자열의 개수 증가
                cntSame = cntDiff = 0;   // 첫 문자와 같거나 다른 문자의 개수 초기화                
                targetIdx = i + 1;   // 분리되고 남은 문자열의 첫 번째 인덱스 갱신
            // 양쪽의 개수가 다른 상태에서 종료되는 경우
            } else if (i == s.length() - 1) answer++;
        }
        
        return answer;
    }
}