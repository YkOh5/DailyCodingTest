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


// 좀 더 고민을 했다면 더 좋은 코드를 쓸 수 있었을텐데...
// class Solution {
//     public int[] solution(int[] num_list, int n) {
//         int[] nums = new int[num_list.length];
//         int idx = 0;
        
//         for (int i = 0; i < num_list.length; i++) {
//             nums[idx++] = num_list[(i + n) % num_list.length];
//         }
        
//         return nums;
//     }
// }