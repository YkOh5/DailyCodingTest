class Solution {
    public String solution(String rsp) {        
        return rsp.replace("2", "s").replace("5", "2").replace("0", "5").replace("s", "0");
    }
}