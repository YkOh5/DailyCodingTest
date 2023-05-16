import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {        
        return (int)(getJaccardIndex(str1, str2) * 65536);
    }
    
    // 두 개의 문자열 간 자카드 유사도 구하기
    private double getJaccardIndex(String str1, String str2) {
        List<String> multiSet1 = getMultiSet(str1);   // 각 문자열에 대한 다중집합
        List<String> multiSet2 = getMultiSet(str2);
        
        if (multiSet1.size() > multiSet2.size()) {
            List<String> tmp = multiSet1;
            multiSet1 = multiSet2;
            multiSet2 = tmp;
        }
        
        int sizeSum = multiSet1.size() + multiSet2.size();   // 두 다중집합의 모든 원소 개수
        int interCnt = 0;   // 교집합의 원소 개수
        
        for (int i = 0; i < multiSet1.size(); i++) {
            if (multiSet2.contains(multiSet1.get(i))) {
                interCnt++;
                multiSet2.remove(multiSet2.indexOf(multiSet1.get(i)));
            }
        }
        
        // 합집합의 원소 개수 = 모든 원소 개수 - 교집합의 원소 개수
        // 자카드 유사도 = 교집합의 원소 개수 / 합집합의 원소 개수
        return (multiSet1.size() == 0 && multiSet2.size() == 0)? 1 : (double)interCnt / (sizeSum - interCnt);
    }
    
    // 입력된 문자열을 주어진 조건에 따른 다중집합으로 변환
    private List<String> getMultiSet(String str) {
        char[] charArr = str.toLowerCase().toCharArray();        
        List<String> multiSet = new ArrayList<>();        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < charArr.length - 1; i++) {
            if (Character.isLetter(charArr[i]) && Character.isLetter(charArr[i + 1])) {
                sb.setLength(0);
                sb.append(charArr[i]);
                sb.append(charArr[i + 1]);
                multiSet.add(sb.toString());
            }
        }
        
        return multiSet;
    }
}