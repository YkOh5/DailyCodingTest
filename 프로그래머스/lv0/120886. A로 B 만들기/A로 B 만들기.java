import java.util.ArrayList;

class Solution {
    public int solution(String before, String after) {
        ArrayList<Character> charList = new ArrayList<>();
        for (char c : before.toCharArray()) charList.add(c);
        
        for (char c : after.toCharArray()) {
            if (!charList.contains(c)) return 0;
            else charList.remove(charList.indexOf(c));
            // else charList.remove(Character.valueOf(c));
        }
        
        return 1;
    }
}



// import java.util.Arrays;

// class Solution {
//     public int solution(String before, String after) {
//         char[] a = before.toCharArray();
//         char[] b = after.toCharArray();

//         Arrays.sort(a);
//         Arrays.sort(b);

//         return new String(a).equals(new String(b)) ? 1 :0;
//     }
// }