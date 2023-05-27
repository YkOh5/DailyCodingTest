import java.util.ArrayList;

class Solution {
    public Integer[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num_list.length; i += n) {
            list.add(num_list[i]);
        }
        
        return list.toArray(new Integer[0]);
    }
}