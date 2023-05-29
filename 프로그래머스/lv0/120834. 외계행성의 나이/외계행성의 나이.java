class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder(Integer.toString(age));
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, (char)(Character.getNumericValue(sb.charAt(i)) + 'a'));
        }
        
        return sb.toString();
    }
}