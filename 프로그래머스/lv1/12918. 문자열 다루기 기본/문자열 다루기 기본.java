class Solution {
    public boolean solution(String s) {
        // 문자열의 길이가 4 혹은 6이 아닌 경우
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        // 문자열의 모든 문자에 대해서
        for (int i = 0; i < s.length(); i++) {
            // 해당 문자가 숫자가 아닌 경우
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}