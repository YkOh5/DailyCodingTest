class Solution {
    public int solution(int n) {
        int sum = 0;
        for (char number : String.valueOf(n).toCharArray()) {
            sum += Character.getNumericValue(number);
        }

        return sum;
    }
}


// class Solution {
//     public int solution(int n) {
//         int answer = 0;
//         for (String str : String.valueOf(n).split("")) {
//             answer += Integer.parseInt(str);
//         }
        
//         return answer;
//     }
// }