import java.util.ArrayList;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_str.length(); i++) {
            sb.append(my_str.charAt(i));
            if (sb.length() >= n || i == my_str.length() - 1) {
                strList.add(sb.toString());
                sb.setLength(0);
            }
        }
        
        return strList.toArray(new String[0]);
    }
}