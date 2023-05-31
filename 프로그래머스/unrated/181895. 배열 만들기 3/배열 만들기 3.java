import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[intervals[0][1] - intervals[0][0] + intervals[1][1] - intervals[1][0] + 2];
        int[] arr1 = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1] + 1);
        int[] arr2 = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1] + 1);
        
        System.arraycopy(arr1, 0, answer, 0, arr1.length);
        System.arraycopy(arr2, 0, answer, arr1.length, arr2.length);
        
        return answer;
    }
}


// import java.util.ArrayList;

// class Solution {
//     public Integer[] solution(int[] arr, int[][] intervals) {
//         return insertValues(arr, intervals).toArray(new Integer[0]);
//     }
    
//     private ArrayList<Integer> insertValues(int[] arr, int[][] intervals) {
//         ArrayList<Integer> arrList = new ArrayList<>();
//         for (int i = 0; i < intervals.length; i++) {
//             for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
//                 arrList.add(arr[j]);
//             }
//         }
        
//         return arrList;
//     }
// }