import java.util.ArrayList;

class Solution {
    public int solution(int[] sides) {
        int sum = 0;
        for (int i = Math.abs(sides[0] - sides[1]) + 1; i < sides[0] + sides[1]; i++) {
            sum++;
        }
        
        return sum;
    }
}