class Solution {
    public String solution(String X, String Y) {
        // 주어진 문자열들에 포함된 각 숫자들의 개수를 기록하기 위한 배열
        int[] numsX = new int[10];
        int[] numsY = new int[10];
        
        // 문자열에 포함된 각각의 숫자와 일치하는 인덱스에 위치한 배열의 원소를 1씩 증가
        for (int i = 0; i < X.length(); i++) numsX[X.charAt(i) - '0']++;
        for (int i = 0; i < Y.length(); i++) numsY[Y.charAt(i) - '0']++;
        
        StringBuilder answer = new StringBuilder();
        
        // 내림차순으로 두 배열을 탐색하며
        for (int i = numsX.length - 1; i >= 0; i--) {
            // 같은 인덱스에 위치한 두 배열의 원소 중 하나라도 0이 될 때까지
            while (numsX[i] > 0 && numsY[i] > 0) {
                answer.append(i);   // 해당 인덱스의 값을 StringBuilder에 추가
                // 해당 원소값 감소
                numsX[i]--;
                numsY[i]--;
            }
        }
        
        // 공통적으로 나타나는 숫자가 없는 경우
        if (answer.length() == 0) return "-1";
        // 공통적으로 나타나는 숫자가 0뿐인 경우
        if (answer.charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}