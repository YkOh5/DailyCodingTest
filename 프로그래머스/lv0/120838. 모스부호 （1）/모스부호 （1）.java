import java.util.HashMap;

class Solution {
    public String solution(String letter) {
        String morseStr = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',"
                + "'--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',"
                + "'--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',"
                + "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',"
                + "'-.--':'y','--..':'z'";
        String[] morseArr = morseStr.split(",");
        String[] letterArr = letter.split(" ");

        HashMap<String, String> morse = new HashMap<String, String>();

        for (int i = 0; i < morseArr.length; i++) {
            morseArr[i] = morseArr[i].replace("'", "");
            int idx = morseArr[i].indexOf(":");
            morse.put(morseArr[i].substring(0, idx), morseArr[i].substring(idx+1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letterArr.length; i++) {
            sb.append(morse.get(letterArr[i]));
        }

        return sb.toString();
    }
}