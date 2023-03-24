class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {        
        // 행의 길이 = arr1.length    
        for (int i = 0; i < arr1.length; i++) {
            // 열의 길이 = arr1[i].length
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        
        return arr1;
    }
}