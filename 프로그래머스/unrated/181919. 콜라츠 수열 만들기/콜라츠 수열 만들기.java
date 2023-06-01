import java.util.ArrayList;

class Solution {
    public Integer[] solution(int n) {
        ArrayList<Integer> collatzSequence = new ArrayList<>();
        collatzSequence.add(n);
        
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else n = 3 * n + 1;
            
            collatzSequence.add(n);
        }
        
        return collatzSequence.toArray(new Integer[0]);
    }
}