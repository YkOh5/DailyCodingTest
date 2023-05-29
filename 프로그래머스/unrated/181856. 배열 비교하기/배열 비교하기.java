class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        else if (arr1.length < arr2.length) return -1;        
        
        return (sumArr(arr1) > sumArr(arr2))? 1 : (sumArr(arr1) < sumArr(arr2))? -1 : 0;
    }
    
    private int sumArr(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        return sum;
    }
}