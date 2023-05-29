class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] nums = new int[num_list.length];
        int idx = 0;
        
        for (int i = n; i < num_list.length; i++) {
            nums[idx++] = num_list[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[idx++] = num_list[i];
        }
        
        return nums;
    }
}