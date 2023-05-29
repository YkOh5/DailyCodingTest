class Solution {
    public String solution(int age) {
        char[] alphabets = new char[10];
        int asciiCode = 97;
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char)asciiCode++;
        }
                
        StringBuilder sb = new StringBuilder(Integer.toString(age));
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, alphabets[Character.getNumericValue(sb.charAt(i))]);
        }
        
        return sb.toString();
    }
}