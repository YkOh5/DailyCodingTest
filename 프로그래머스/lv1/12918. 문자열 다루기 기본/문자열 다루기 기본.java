class Solution {
    public boolean solution(String s) {
        // 문자열의 길이가 4 혹은 6이 아닌 경우
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        // 문자열의 모든 문자에 대해서
        for (int i = 0; i < s.length(); i++) {
            // 해당 문자가 숫자가 아닌 경우
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        
        return true;
        
        
        // 정규식을 잘 활용하면, 단 한 줄로 해결 가능
        // return s.matches("\\d{4}|\\d{6}");
        
        
        // 정수로 변환이 불가능한 문자열에 대한 오류를 이용하는 방법
        // if(s.length() == 4 || s.length() == 6){            
        //     try{
        //         int x = Integer.parseInt(s);
        //         return true;
        //     } catch(NumberFormatException e){
        //         return false;
        //     }
        // } else return false;
    }
}