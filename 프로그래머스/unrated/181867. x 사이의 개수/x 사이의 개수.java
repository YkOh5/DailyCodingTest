import java.util.ArrayList;

class Solution {
    public Integer[] solution(String myString) {
        ArrayList<Integer> lengthList = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                lengthList.add(cnt);
                cnt = 0;
            } else cnt++;
        }
        
        lengthList.add(cnt);
        
        return lengthList.toArray(new Integer[0]);
    }
}