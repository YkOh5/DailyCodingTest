class Solution {
    public String solution(String my_string, int[] indices) {
        char[] my_chars = my_string.toCharArray();
        for (int index : indices) {
            my_chars[index] = '0';
        }
        
        StringBuilder my_sb = new StringBuilder();
        for (char c : my_chars) {
            if (c != '0') my_sb.append(c);
        }
        
        return my_sb.toString();
    }
}