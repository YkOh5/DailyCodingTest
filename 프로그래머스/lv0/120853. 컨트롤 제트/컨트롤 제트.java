class Solution {
    public int solution(String s) {
        int sum = 0;
        int prevNum = 0;
        for (String str : s.split(" ")) {
            if (str.equals("Z")) sum -= prevNum;
            else {                
                sum += Integer.parseInt(str);
                prevNum = Integer.parseInt(str);
            }  
        }
        
        return sum;
    }
}