class Solution {
    public int solution(int[] num_list) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int idx = 0; idx < num_list.length; idx++) {
            if (idx % 2 != 0) sumOdd += num_list[idx];
            else sumEven += num_list[idx];
        }
        
        return Math.max(sumOdd, sumEven);
    }
}