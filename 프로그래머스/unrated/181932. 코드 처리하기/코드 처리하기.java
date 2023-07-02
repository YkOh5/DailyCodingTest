class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        for (int idx = 0; idx < code.length(); idx++) {
            if (code.charAt(idx) == '1') mode = 1 - mode;
            else if (idx % 2 == mode) sb.append(code.charAt(idx));
        }
        
        return (sb.length() == 0)? "EMPTY" : sb.toString();
    }
}