class Solution {
    public int solution(int[] array) {
        StringBuilder sb = new StringBuilder();        
        for (int num : array) {
            sb.append(num);
        }
        
        int cnt = 0;
        for (char c : sb.toString().toCharArray()) {
            if (Character.getNumericValue(c) == 7) cnt++;
        }
        
        return cnt;
    }
}