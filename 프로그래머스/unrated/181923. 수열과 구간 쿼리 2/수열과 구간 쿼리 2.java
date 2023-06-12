import java.util.ArrayList;

class Solution {
    public Integer[] solution(int[] arr, int[][] queries) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int[] query : queries) {
            int validNum = Integer.MAX_VALUE;
            boolean containsValidNum = false;
            for (int idx = query[0]; idx <= query[1]; idx++) {                
                if (arr[idx] > query[2]) {
                    validNum = Math.min(validNum, arr[idx]);
                    containsValidNum = true;
                }
            }
            validNum = (containsValidNum)? validNum : -1;
            numList.add(validNum);
        }
        
        return numList.toArray(new Integer[0]);
        // return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}