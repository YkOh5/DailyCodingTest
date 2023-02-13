import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx % 2 == 0 && 97 <= s.charAt(i) && s.charAt(i) <= 122) {
                    sb.append((char)(s.charAt(i) - 32));                
            } else if (idx % 2 != 0 && 65 <= s.charAt(i) && s.charAt(i) <= 90) {
                    sb.append((char)(s.charAt(i) + 32));                             
            } else {
                sb.append(s.charAt(i));
            }
            
            idx++;
            
            if (s.charAt(i) == 32) {
                idx = 0;
            }
        }
        
        return sb.toString();
    }
}