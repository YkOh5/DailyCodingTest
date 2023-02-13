// 1. 주어진 문자열의 문자에 대해서 해당 문자가 공백일 경우 초기화 되는 별도의 인덱스를 이용
// 2. 해당 인덱스가 짝수인 경우, 소문자(97 <= ASCII 값 <= 122)이면 대문자(AsCII값 - 32)로
// 3. 홀수인 경우, 대문자(65 <= ASCII 값 <= 90)이면 대문자(AsCII값 + 32)로
// 4. 그 외 경우, 문자 그대로 새로운 문자열에 추가하여 반환

import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // 공백을 기준으로 초기화 되는 인덱스
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 인덱스가 짝수이고, 해당 문자가 소문자인 경우 -> 대문자로 변환
            if (idx % 2 == 0 && 97 <= s.charAt(i) && s.charAt(i) <= 122) {
                    sb.append((char)(s.charAt(i) - 32));
            // 인덱스가 홀수이고, 해당 문자가 대문자인 경우 -> 소문자로 변환
            } else if (idx % 2 != 0 && 65 <= s.charAt(i) && s.charAt(i) <= 90) {
                    sb.append((char)(s.charAt(i) + 32));                             
            } else {
                sb.append(s.charAt(i));
            }
            
            idx++;
            
            // 해당 문자가 공백일 경우 인덱스 초기화
            if (s.charAt(i) == 32) {
                idx = 0;
            }
        }
        
        return sb.toString();
    }
}