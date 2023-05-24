class Solution {
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String element : arr) sb.append(element);
        
        return sb.toString();
    }
}


// class Solution {
//     public String solution(String[] arr) {        
//         return String.join("", arr);
//     }
// }