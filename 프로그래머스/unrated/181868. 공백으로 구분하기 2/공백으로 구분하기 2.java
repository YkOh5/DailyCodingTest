class Solution {
    public String[] solution(String my_string) {
        return my_string.trim().replaceAll("\\s+", " ").split(" ");
        
        // 더 간단히 해결할 수 있다
        // return my_string.trim().split("\\s+");
        // return my_string.trim().split("[ ]+");
    }
}