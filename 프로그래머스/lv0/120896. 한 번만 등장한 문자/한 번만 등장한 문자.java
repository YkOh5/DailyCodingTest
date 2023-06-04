class Solution {
    public String solution(String s) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < cnts.length; idx++) {
            if (cnts[idx] == 1) sb.append((char)('a' + idx));
        }
        
        return sb.toString();
    }
}