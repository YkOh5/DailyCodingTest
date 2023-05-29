import java.util.ArrayList;

class Solution {
    public Integer[] solution(String my_string) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) numList.add(Character.getNumericValue(c));
        }

        numList.sort(null);

        return numList.toArray(new Integer[0]);
    }
}