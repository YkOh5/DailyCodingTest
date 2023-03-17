class Solution {
    public String solution(String phone_number) {
        // 문자열을 다룰 때는 StringBuilder 혹은 StringBuffer 클래스를 사용하는 것이 효율적
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < phone_number.length(); i++) {
            // 주어진 전화번호의 뒤쪽 4자리를 제외한 나머지 숫자들을 *로 마스킹
            if (i < phone_number.length() - 4) {
                sb.append("*");
            // 뒤쪽 4자리는 그대로 이어붙임
            } else {
                sb.append(phone_number.charAt(i));   
            }
        }
        // 문자열로 변환해서 반환
        return sb.toString();
    }
}