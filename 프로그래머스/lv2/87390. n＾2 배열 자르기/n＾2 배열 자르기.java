class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        
        for (long i = left; i <= right; i++) {            
            int quotient = (int)(i / n);   // 몫
            int remainder = (int)(i % n);   // 나머지
            
            if (quotient <= remainder ) answer[idx++] = remainder + 1;
            else answer[idx++] = quotient + 1;
        }
        
        return answer;
    }
}