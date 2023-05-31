class Solution {
    public int solution(String binomial) {
        String[] bi = binomial.split(" ");
        int a = Integer.parseInt(bi[0]);
        int b = Integer.parseInt(bi[2]);
        
        switch (bi[1]) {
            case "+" -> {return a + b;}
            case "-" -> {return a - b;}
        }
        
        return a * b;
    }
}