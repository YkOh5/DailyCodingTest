class Solution {
    public String[] solution(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = (i % 2 != 0)? strArr[i].toUpperCase() : strArr[i].toLowerCase();
        }
        
        return strArr;
    }
}