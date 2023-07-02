import java.util.ArrayList;

class Solution {
    public Integer[] solution(int l, int r) {
        ArrayList<Integer> validNumList = new ArrayList<>();
        for (int number = l; number <= r; number++) {
            if (isValidNumber(number)) validNumList.add(number);
        }
        
        return (validNumList.size() == 0)? new Integer[]{-1} : validNumList.toArray(new Integer[0]);
    }

    private boolean isValidNumber(int number) {
        for (char c : String.valueOf(number).toCharArray()) {
            int targetNum = Character.getNumericValue(c);
            if (targetNum != 0 && targetNum != 5) return false;
        }

        return true;
    }
}