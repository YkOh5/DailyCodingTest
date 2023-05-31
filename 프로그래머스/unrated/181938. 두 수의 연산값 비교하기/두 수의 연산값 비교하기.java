class Solution {
    public int solution(int a, int b) {        
        return Math.max(Integer.parseInt("" + a + b), 2 * a * b);
    }
}


// class Solution {
//     public int solution(int a, int b) {
//         StringBuilder sb = new StringBuilder(String.valueOf(a));        
//         sb.append(String.valueOf(b));
//         return Math.max(Integer.parseInt(sb.toString()), 2 * a * b);
//     }
// }