// 두 행렬의 크기가 각각 l * m, m * n 일 때, 곱한 결과로 얻는 행렬의 크기는 l * n
// 두 행렬을 곱한 행렬의 원소들은 첫 행렬의 행(row)과 두 번째 행렬의 열(column)을 곱한 값들의 합

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
                
        return answer;
    }
}