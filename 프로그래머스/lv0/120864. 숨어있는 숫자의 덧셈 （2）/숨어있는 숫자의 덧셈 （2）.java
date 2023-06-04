class Solution {
    public int solution(String my_string) {
        int sum = 0;
        for (String str : my_string.replaceAll("[^0-9]", " ").split("\\s+")) {
            if (!str.isEmpty()) sum += Integer.parseInt(str);
        }
        
        return sum;
    }
}