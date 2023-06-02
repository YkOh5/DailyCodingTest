import java.util.*;
class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                "...","-","..-","...-",".--","-..-","-.--","--.."};

        // Using Map Structure, matching <'morse' : 'alphabet'> 
        Map<String, Character> map = new HashMap<>();
        for(int i=0; i< morse.length; i++) 
            map.put(morse[i], (char)(97+i));

        // letter split and interpret
        String[] words = letter.split(" ");
        for(String x :words) 
            answer += map.get(x);

        return answer;
    }
}