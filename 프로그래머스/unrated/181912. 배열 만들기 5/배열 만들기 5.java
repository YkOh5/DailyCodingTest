import java.util.ArrayList;

class Solution {
    public Integer[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (String intStr : intStrs) {
            int target = Integer.parseInt(intStr.substring(s, s + l));
            if (target > k) intList.add(target);
        }
        
        return intList.toArray(new Integer[0]);
    }
}