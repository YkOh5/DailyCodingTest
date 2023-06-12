import java.util.ArrayList;

class Solution {
    public Integer[] solution(int[] arr, int[][] queries) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int[] query : queries) {
            int targetNum = Integer.MAX_VALUE;
            boolean containsTargetNum = false;
            for (int idx = query[0]; idx <= query[1]; idx++) {                
                if (arr[idx] > query[2]) {
                    targetNum = Math.min(targetNum, arr[idx]);
                    containsTargetNum = true;
                }
            }
            targetNum = (containsTargetNum)? targetNum : -1;
            numList.add(targetNum);
        }
        
        return numList.toArray(new Integer[0]);
    }
}