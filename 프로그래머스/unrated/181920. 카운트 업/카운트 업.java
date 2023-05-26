import java.util.ArrayList;

class Solution {
    public Integer[] solution(int start, int end) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numList.add(i);
        }        
        
        return numList.toArray(new Integer[0]);
    }
}