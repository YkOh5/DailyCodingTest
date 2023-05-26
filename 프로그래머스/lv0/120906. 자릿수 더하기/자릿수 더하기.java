class Solution {
    public int solution(int n) {
        int sum = 0;
        for (char number : String.valueOf(n).toCharArray()) {
            sum += Character.getNumericValue(number);
        }
        
        return sum;
    }
}