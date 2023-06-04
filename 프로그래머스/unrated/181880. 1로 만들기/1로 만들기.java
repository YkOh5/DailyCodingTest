class Solution {
    private int sumCntDiv = 0;
    
    public int solution(int[] num_list) {
        for (int num : num_list) sumCntDiv += cntDiv(num);
        
        return sumCntDiv;
    }
    
    private int cntDiv(int num) {
        int cnt = 0;
        while (num != 1) {
            num = (num % 2 == 0)? num / 2 : (num - 1) / 2;
            cnt++;
        }
        
        return cnt;
    }
}