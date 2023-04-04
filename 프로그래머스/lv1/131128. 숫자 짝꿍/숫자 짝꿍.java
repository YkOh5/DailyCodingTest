class Solution {
    public String solution(String X, String Y) {
        int[] numsX = new int[10];
        int[] numsY = new int[10];
        
        // for (int i = 0; i < X.length(); i++) numsX[X.charAt(i) - '0']++;
        // for (int i = 0; i < Y.length(); i++) numsY[Y.charAt(i) - '0']++;
        
        // Character.getNumericValue();        
        for (int i = 0; i < X.length(); i++) numsX[Character.getNumericValue(X.charAt(i))]++;
        for (int i = 0; i < Y.length(); i++) numsY[Character.getNumericValue(Y.charAt(i))]++;
        
        // for each + getNV
        // for (char num : X.toCharArray()) numsX[Character.getNumericValue(num)]++;
        // for (char num : Y.toCharArray()) numsY[Character.getNumericValue(num)]++;
        
        StringBuilder answer = new StringBuilder();
        for (int i = numsX.length - 1; i >= 0; i--) {
            while (numsX[i] > 0 && numsY[i] > 0) {
                answer.append(i);
                numsX[i]--;
                numsY[i]--;
            }
        }
        
        if (answer.length() == 0) return "-1";
        
        if (answer.charAt(0) == '0') return "0";        
        
        return answer.toString();
    }
}