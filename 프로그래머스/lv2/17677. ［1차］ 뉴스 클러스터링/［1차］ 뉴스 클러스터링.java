import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {        
        return (int)(getJaccardIndex(str1, str2) * 65536);
    }
    
    private List<String> getMultiSet(String str) {
        char[] charArr = str.toLowerCase().toCharArray();   
        
        List<String> list = new ArrayList<>();        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length - 1; i++) {
            if (Character.isLetter(charArr[i]) && Character.isLetter(charArr[i + 1])) {
                sb.setLength(0);
                sb.append(charArr[i]);
                sb.append(charArr[i + 1]);
                list.add(sb.toString());
            }
        }
        
        return list;
    }
    
    private double getJaccardIndex(String str1, String str2) {
        List<String> multiSet1 = getMultiSet(str1);
        List<String> multiSet2 = getMultiSet(str2);
        
        if (multiSet1.size() > multiSet2.size()) {
            List<String> tmp = multiSet1;
            multiSet1 = multiSet2;
            multiSet2 = tmp;
        }
        
        int sizeSum = multiSet1.size() + multiSet2.size();
        int interCnt = 0;
        for (int i = 0; i < multiSet1.size(); i++) {
            if (multiSet2.contains(multiSet1.get(i))) {
                interCnt++;
                multiSet2.remove(multiSet2.indexOf(multiSet1.get(i)));
            }
        }
        
        return (multiSet1.size() == 0 && multiSet2.size() == 0)? 1 : (double)interCnt / (sizeSum - interCnt);
    }
}