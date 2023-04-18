import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public Integer[] solution(String today, String[] terms, String[] privacies) {             
        return getExpiredPrivacyNumbers(today, getExpirationDates(terms, privacies));
    }
    
    // 특정 날짜에 대한 총 일 수
    private int getTotalDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        return (year * 12 + month) * 28 + day;
    }
    
    // 약관에 따른 각 개인정보의 만료일
    private int[] getExpirationDates(String[] terms, String[] privacies) {
        // 약관의 종류별 유효기간
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            termsMap.put(term.charAt(0), Integer.parseInt(term.substring(1).trim()) * 28);
        }
        
        int[] expDates = new int[privacies.length];
        for (int i = 0; i < privacies.length; i++) {
            int collDates = getTotalDays(privacies[i]);   // 개인정보 수집 일자
            int validityPeriod = termsMap.get(privacies[i].charAt(privacies[i].length() - 1));   // 유효기간
                        
            expDates[i] = collDates + validityPeriod;   // 만료일
        }
                
        return expDates;        
    }
    
    // 유효기간 초과로 파기해야할 개인정보의 번호
    private Integer[] getExpiredPrivacyNumbers (String today, int[] expDates) {
        ArrayList<Integer> expPrNums = new ArrayList<>();
        int curDate = getTotalDays(today);   // 현재 일자
        for (int i = 0; i < expDates.length; i++) {
            if (curDate >= expDates[i]) expPrNums.add(i + 1);
        }
        
        return expPrNums.toArray(new Integer[0]);
    }
}