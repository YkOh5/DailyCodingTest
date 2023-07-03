import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int maxCnt = 0, domNum = 1;
        for (int number : array) {
            cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
            
            int cnt = cntMap.get(number);
            if (cnt > maxCnt) {
                domNum = number;
                maxCnt = cnt;
            } else if (cnt == maxCnt) domNum = -1;
        }
        
        return domNum;
    }
}