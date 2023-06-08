class Solution {
    public int solution(String my_string) {
        int sum = 0;
        boolean isPositive = true;
        for (String str : my_string.split(" ")) {
            if (str.equals("+")) isPositive = true;
            else if (str.equals("-")) isPositive = false;
            else {
                sum += (isPositive)? Integer.parseInt(str) : -1 * Integer.parseInt(str);
            }
        }
        
        return sum;
    }
}