import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        if (myString.replaceAll("\\s+", "").charAt(0) == 'x') myString = myString.replaceFirst("x", "");
        String[] strArr = myString.replaceAll("\\s+", "").split("x+");
        Arrays.sort(strArr);
        
        return strArr;
    }
}