// class Solution {
//     public int[] solution(int n) {        
//         int[] answer = new int[(n % 2 == 0)? n / 2 : n / 2 + 1];
//         int idx = 0;
//         for (int i = 1; i <= n; i += 2) {
//             answer[idx++] = i;
//         }
        
//         return answer;
//     }
// }


import java.util.ArrayList;

class Solution {
    public Integer[] solution(int n) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i += 2) {
            numList.add(i);
        }
        
        return numList.toArray(new Integer[0]);
    }
}