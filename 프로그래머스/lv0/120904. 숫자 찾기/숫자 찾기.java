class Solution {
    public int solution(int num, int k) {
//         char[] nums = String.valueOf(num).toCharArray();
//         for (int i = 0; i < nums.length; i++) {
//             if (Character.getNumericValue(nums[i]) == k) return i + 1;
//         }
        
//         return -1;
        
        return ("a" + num).indexOf(Integer.toString(k));
    }
}