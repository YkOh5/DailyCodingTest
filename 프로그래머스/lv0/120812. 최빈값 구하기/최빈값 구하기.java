import java.util.HashMap;

class Solution {
    private HashMap<Integer, Integer> cntMap = new HashMap<>();

    public int solution(int[] array) {
        for (int number : array) {
            cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
        }

        return getDominantNumber();
    }

    private int getDominantNumber() {
        int maxCnt = 0;
        int domNum = -1;
        for (int key : cntMap.keySet()) {
            int cnt = cntMap.get(key);
            if (cnt > maxCnt) {
                domNum = key;
                maxCnt = cnt;
            } else if (cnt == maxCnt) domNum = -1;
        }

        return domNum;
    }
}