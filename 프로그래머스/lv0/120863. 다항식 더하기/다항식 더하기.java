class Solution {
    private int coefA = 0, coefB = 0;
    
    public String solution(String polynomial) {        
        for (String term : polynomial.split(" \\+ ")) {
            if (term.equals("x")) coefA++;
            else if (term.contains("x")) coefA += Integer.parseInt(term.replace("x", ""));
            else coefB += Integer.parseInt(term);
        }        
        
        return buildAnswer(coefA, coefB);
    }
    
    private String buildAnswer(int coefA, int coefB) {
        StringBuilder sb = new StringBuilder();
        if (coefA == 0) sb.append(coefB);
        else {
            if (coefA == 1) sb.append("x");
            else sb.append(coefA + "x");
            if (coefB != 0) sb.append(" + " + coefB);
        }
        
        return sb.toString();
    }
}