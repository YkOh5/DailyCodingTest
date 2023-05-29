class Solution {
    public int solution(int a, int b, int c) {
        int type1 = a + b + c;
        int type2 = type1 * (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        int type3 = type2 * (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
        
        if (a != b && b != c && c != a) return type1;
        else if (a == b && b == c) return type3;
        
        return type2;
    }
}