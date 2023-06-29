import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist).mapToObj(a->(Integer)a)
            .sorted((a, b)->{
                int u = Math.abs(n - a);
                int v = Math.abs(n - b);
                if(u == v) return b - a;
                else return u - v;
            })
            .mapToInt(a->a)
            .toArray();
    }
}