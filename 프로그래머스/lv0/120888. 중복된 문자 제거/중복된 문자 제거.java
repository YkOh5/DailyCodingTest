import java.util.HashSet;

class Solution {
    public String solution(String my_string) {
        HashSet<Character> charSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (!charSet.contains(c)) sb.append(c);
            charSet.add(c);
        }
        
        return sb.toString();
    }
}