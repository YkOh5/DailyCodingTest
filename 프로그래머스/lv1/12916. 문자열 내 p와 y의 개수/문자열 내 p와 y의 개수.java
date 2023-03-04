// 1. 문자열 s의 각 문자에 대해
// 2. p 또는 P 인 문자의 수와 y 또는 Y 인 문자의 수가 같으면 true를 반환
// 3. 다르면 false를 반환

class Solution {
    boolean solution(String s) {
        int cntP = 0;
        int cntY = 0;
        
        // 문자열 s의 각 문자에 대해
        for (int i = 0; i < s.length(); i++) {
            // 해당 문자가 p 또는 P 인 경우
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                cntP++;
            // 해당 문자가 y 또는 Y 인 경우
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                cntY++;
            }
        }
        
        if (cntP == cntY) {
            return true;
        }
        
        return false;
    }
}