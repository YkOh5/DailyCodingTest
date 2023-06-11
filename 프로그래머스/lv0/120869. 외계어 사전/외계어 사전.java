import java.util.HashMap;

class Solution {
    private HashMap<Character, Integer> letterMap;
    
    public int solution(String[] alphabet, String[] dic) {
        for (String word : dic) {
            boolean theWordIs = true;
            letterMap = new HashMap<>();
            
            for (char c : word.toCharArray()) {
                letterMap.put(c, letterMap.getOrDefault(c, 0) + 1);
            }
            
            for (String letter : alphabet) {
                if (letterMap.getOrDefault(letter.charAt(0), 0) != 1) {
                    theWordIs = false;
                    break;
                }
            }
            
            if (theWordIs) return 1;
        }
        
        return 2;
    }
}