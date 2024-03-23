import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<String> dict = new ArrayList<>();
        
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            dict.add(String.valueOf(letter));
        }
        
        ArrayList<Integer> idxList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder prevSb;
        
        for (int i = 0; i < msg.length(); i++) {
            prevSb = new StringBuilder(sb.toString());
            sb.append(msg.charAt(i));
            
            if (dict.indexOf(sb.toString()) != -1) continue;
            
            idxList.add(dict.indexOf(prevSb.toString()) + 1);
            dict.add(sb.toString());
            sb.setLength(0);
            i--;
        }
        
        idxList.add(dict.indexOf(sb.toString()) + 1);
        
        return idxList;
    }
}