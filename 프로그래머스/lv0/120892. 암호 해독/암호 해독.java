class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for (int idx = code - 1; idx < cipher.length(); idx += code) {
            sb.append(cipher.charAt(idx));
        }
        
        return sb.toString();
    }
}