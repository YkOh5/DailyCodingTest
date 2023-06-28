class Solution {
    public int solution(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            StringBuilder sb = new StringBuilder(A.substring(A.length() - i));
            sb.append(A.substring(0, A.length() - i));
            if (sb.toString().equals(B)) return i;
        }
        
        return -1;
    }
}



// 아래와 같은 방법으로 더 간단하게 해결할 수 있다
// class Solution {
//     public int solution(String A, String B) {
//         return B.repeat(2).indexOf(A);
//     }
// }