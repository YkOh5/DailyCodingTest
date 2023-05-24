class Solution {
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String element : arr) sb.append(element);
        
        return sb.toString();
    }
}


// String.join()을 사용하면 훨씬 더 간단하고 효율적으로 해결할 수 있다
// 주어진 문자열 배열의 크기가 크면 클수록 String
// class Solution {
//     public String solution(String[] arr) {        
//         return String.join("", arr);
//     }
// }