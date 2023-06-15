class Solution {
    public String solution(String my_str, String overwrite_str, int s) {
        return new StringBuilder(my_str).replace(s, s + overwrite_str.length(), overwrite_str).toString();
    }
}