class Solution {
    public String[] solution(String myStr) {
        String[] answer = myStr.replaceAll("[a-c]", " ").trim().split("\\s+");
        return (answer[0].equals(""))? new String[]{"EMPTY"} : answer;
    }
}