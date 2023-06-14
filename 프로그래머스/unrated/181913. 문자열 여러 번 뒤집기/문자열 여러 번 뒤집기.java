class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int[] query : queries) {
            my_string = sb.toString();
            String revStr = new StringBuilder(my_string.substring(query[0], query[1] + 1)).reverse().toString();
            sb.replace(query[0], query[1] + 1, revStr);
        }
        
        return sb.toString();
    }
    
    
}



// class Solution {
//     public String solution(String my_string, int[][] queries) {
//         StringBuilder sb = new StringBuilder(my_string);
//         for (int[] query : queries) {            
//             my_string = sb.toString();
//             sb.setLength(0);
//             StringBuilder subSb = new StringBuilder(my_string.substring(query[0], query[1] + 1)).reverse();
//             sb.append(my_string.substring(0, query[0]));
//             sb.append(subSb);
//             sb.append(my_string.substring(query[1] + 1, my_string.length()));            
//         }

//         return sb.toString();
//     }
// }