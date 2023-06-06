import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : myStr.toCharArray()) {
            if (c != 'a' && c != 'b' && c != 'c') sb.append(c);
            else if (sb.length() != 0) {
                strList.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() != 0) strList.add(sb.toString());
        
        return strList.size() == 0? new String[]{"EMPTY"} : strList.toArray(new String[0]);
    }
}



// class Solution {
//     public String[] solution(String myStr) {
//         String[] answer = myStr.replaceAll("[a-c]+", " ").trim().split("\\s+");
//         return (answer[0].equals(""))? new String[]{"EMPTY"} : answer;
//     }
// }