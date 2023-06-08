class Solution {
    public int solution(String[] strArr) {
        int[] cnts = new int[30];
        for (String str : strArr) {
            cnts[str.length() - 1]++;
        }
        
        int maxCnt = 0;
        for (int cnt : cnts) {
            maxCnt = Math.max(maxCnt, cnt);
        }
        
        return maxCnt;
    }
}