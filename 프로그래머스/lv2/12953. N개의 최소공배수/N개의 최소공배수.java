class Solution {
    public int solution(int[] arr) {
        long product = 1;
        for (int num : arr) {
            product *= num;
        }
        
        for (int i = 1; i <= product; i++) {
            boolean chk = true;
            if (product % i != 0) continue;
            for (int num : arr) {
                if (i % num != 0) {
                    chk = false;
                    break;
                }
            }
            if (chk == true) return i;
        }
        
        return 1;
    }
}