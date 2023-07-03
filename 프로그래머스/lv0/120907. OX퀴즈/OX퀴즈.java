class Solution {
    public String[] solution(String[] quiz) {
        int idx = 0;
        for (String equation : quiz) {
            int sum = 0;
            boolean positiveSign = true;
            String[] eqArr = equation.split(" ");            
            for (String str : eqArr) {
                if (str.equals("+")) positiveSign = true;
                else if (str.equals("-")) positiveSign = false;
                else if (str.equals("="))
                    quiz[idx] = (sum == Integer.parseInt(eqArr[eqArr.length - 1]))? "O" : "X";
                else {
                    sum += (positiveSign)? Integer.parseInt(str) : Integer.parseInt(str) * -1;
                }
            }            
            idx++;
        }

        return quiz;
    }
}


// class Solution {
//     public String[] solution(String[] quiz) {        
//         for (int idx = 0; idx < quiz.length; idx++) {
//             String[] str = quiz[idx].split(" ");
//             int sum = Integer.parseInt(str[0]) + Integer.parseInt(str[2]) * ((str[1].equals("+")) ? 1 : -1);
//             quiz[idx] = (Integer.parseInt(str[4]) == sum)? "O" : "X";            
//         }
        
//         return quiz;
//     }
// }