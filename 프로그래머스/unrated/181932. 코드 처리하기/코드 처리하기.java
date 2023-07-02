class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        char[] chars = code.toCharArray();
        
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] == '1') {
                mode = 1 - mode; // mode 값을 토글합니다.
            } else if ((mode == 0 && idx % 2 == 0) || (mode == 1 && idx % 2 != 0)) {
                sb.append(chars[idx]);
            }
        }
        
        return (sb.length() == 0) ? "EMPTY" : sb.toString();
    }
}
