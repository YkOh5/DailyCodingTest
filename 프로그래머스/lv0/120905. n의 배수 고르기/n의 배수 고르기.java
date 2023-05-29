import java.util.ArrayList;

class Solution {
    public Integer[] solution(int n, int[] numArr) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : numArr) {
            if (num % n == 0) numList.add(num);
        }
        
        return numList.toArray(new Integer[0]);
    }
}


// import java.util.Arrays;

// class Solution {
//     public int[] solution(int n, int[] numList) {
//         return Arrays.stream(numList).filter(value -> value % n == 0).toArray();
//     }
// }