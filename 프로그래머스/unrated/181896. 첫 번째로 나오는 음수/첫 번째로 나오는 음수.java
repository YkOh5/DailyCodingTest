class Solution {
    public int solution(int[] num_list) {
        for (int idx = 0; idx < num_list.length; idx++) {
            if (num_list[idx] < 0) return idx;
        }
        
        return -1;
    }
}