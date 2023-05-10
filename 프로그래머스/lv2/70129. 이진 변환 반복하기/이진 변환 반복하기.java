class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {            
            String[] cntZero = s.split("0", -1);               
            if (s.contains("0")) {
                s = s.replace("0", "");
                answer[1] += cntZero.length - 1;
            }            
            
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        
        return answer;
    }
}