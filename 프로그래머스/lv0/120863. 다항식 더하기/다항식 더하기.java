class Solution {
    public String solution(String polynomial) {
        int a = 0, b = 0;
        for (String term : polynomial.split(" \\+ ")) {
            if (term.equals("x")) a++;
            else if (term.contains("x")) a += Integer.parseInt(term.replace("x", ""));
            else b += Integer.parseInt(term);
        }        
        
        return buildAnswer(a, b);
    }
    
    private String buildAnswer(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        if (a == 0) sb.append(b);
        else {
            if (a == 1) sb.append("x");
            else sb.append(a + "x");
            
            if (b != 0) sb.append(" + " + b);
        }
        
        
        
        return sb.toString();
    }
}