class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int len1 = intervals[0][1] - intervals[0][0] + 1;
        int len2 = intervals[1][1] - intervals[1][0] + 1;
        int[] answer = new int[len1 + len2];
        
        System.arraycopy(arr, intervals[0][0], answer, 0, len1);
        System.arraycopy(arr, intervals[1][0], answer, len1, len2);
        
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