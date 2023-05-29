import java.util.ArrayList;

class Solution {
    public Integer[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : arr) numList.add(num);
        
        for (int num : delete_list) {
            if (numList.contains(num)) {
                numList.remove(numList.indexOf(num));
            }
        }
                
        return numList.toArray(new Integer[0]);
    }
}