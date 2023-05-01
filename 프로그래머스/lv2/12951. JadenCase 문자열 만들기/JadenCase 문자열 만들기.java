// 1. 문자열의 모든 문자를 소문자로 변환
// 2. 첫 문자를 대문자로 변환하여 StringBuilder에 추가
// 3. 나머지 모든 문자들에 대해서 이전 문자가 공백이면 해당 문자를 대문자로 변환하여 추가
// 4. 공백이 아니면 소문자 그대로 추가

class Solution {
    public String solution(String s) {
        char[] charArr = s.toLowerCase().toCharArray();        
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(charArr[0]));
        
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i - 1] == ' ') sb.append(Character.toUpperCase(charArr[i]));
            else sb.append(charArr[i]);
        }
        
        return sb.toString();
    }
}