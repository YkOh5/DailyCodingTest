import java.util.Arrays;

// class Solution {
//     public String solution(String my_string) {
//         String[] strArr = my_string.toLowerCase().split("");
//         Arrays.sort(strArr);
        
//         return String.join("", strArr);
//     }
// }


class Solution {
    public String solution(String my_string) {
        char[] charArr = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArr);
        
        return new String(charArr);
    }
}