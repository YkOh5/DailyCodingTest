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



// import java.util.Arrays;
// import java.util.LinkedHashSet;
// import java.util.List;

// class Solution {
//     public String solution(String my_string) {
//         return String.join("", new LinkedHashSet<String>(Arrays.asList(my_string.split(""))));
//     }
// }



// import java.util.stream.Collectors;

// class Solution {
//     public String solution(String my_string) {
//         return my_string.chars()
//                 .mapToObj(Character::toString)
//                 .distinct()
//                 .collect(Collectors.joining());
//     }
// }



// import java.util.*;
// import java.util.stream.Collectors;

// class Solution {
//     public String solution(String myString) {
//         return Arrays.stream(myString.split("")).distinct().collect(Collectors.joining());
//     }
// }