class Solution {
    public String solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        int targetIdx = 0;
        int idx = 0;
        for (char c : myString.toCharArray()) {
            sb.append(c);
            if (sb.toString().endsWith(pat)) targetIdx = idx;
            idx++;
        }
        
        return myString.substring(0, targetIdx + 1);
    }
}