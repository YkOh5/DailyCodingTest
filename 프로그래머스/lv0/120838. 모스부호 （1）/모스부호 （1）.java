import java.util.HashMap;

class Solution {
    private HashMap<String, String> morseMap;
    private String morse = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f','--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l','--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r','...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'";
    
    public String solution(String letter) {
        morseMap = buildMorseMap(morse);
        
        return decode(letter);
    }
    
    private HashMap<String, String> buildMorseMap(String morse) {
        HashMap<String, String> morseMap = new HashMap<>();
        for (String code : morse.replace("'", "").split(",")) {
            String[] dotAndAlphabet = code.split(":");
            morseMap.put(dotAndAlphabet[0], dotAndAlphabet[1]);
        }
        
        return morseMap;
    }
    
    private String decode(String letter) {
        StringBuilder sb = new StringBuilder();
        for (String ditDah : letter.split(" ")) {
            sb.append(morseMap.get(ditDah));
        }
        
        return sb.toString();
    }
}