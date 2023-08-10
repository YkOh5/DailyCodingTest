import java.util.*;

class Solution {
    private String[] vowels = {"A", "E", "I", "O", "U"};
    private String word;    
    private int maxLength = vowels.length;    
    private int cnt = 0;
    private int answer;
    
    
    public int solution(String word) {
        this.word = word;        
        getValidCnt(new StringBuilder());
        
        return answer;
    }

    private void getValidCnt(StringBuilder curStr) {
        if (curStr.length() <= maxLength) {
            if (word.equals(curStr.toString())) answer = cnt;
            cnt++;
            
            for (String vowel : vowels) {
                getValidCnt(new StringBuilder(curStr).append(vowel));
            }
        }
    }
}