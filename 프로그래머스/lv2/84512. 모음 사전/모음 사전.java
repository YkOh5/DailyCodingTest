import java.util.*;

class Solution {
    private String word;
    private int answer, maxLength;
    private int cnt = 0;    
    
    
    public int solution(String word) {
        String[] vowels = {"A", "E", "I", "O", "U"};
        this.word = word;
        maxLength = vowels.length;

        getValidCnt(vowels, new String());
        
        return answer;
    }

    private void getValidCnt(String[] vowels, String curStr) {
        if (curStr.length() <= maxLength) {
            if (word.equals(curStr)) answer = cnt;
            cnt++;
            
            for (String vowel : vowels) {
                getValidCnt(vowels, curStr + vowel);
            }
        }
    }
}