class Solution {
    public String[] solution(String[] quiz) {        
        for (int idx = 0; idx < quiz.length; idx++) {
            String[] str = quiz[idx].split(" ");
            int sum = Integer.parseInt(str[0]) + Integer.parseInt(str[2]) * ((str[1].equals("+")) ? 1 : -1);
            quiz[idx] = (Integer.parseInt(str[str.length - 1]) == sum)? "O" : "X";            
        }
        
        return quiz;
    }
}
