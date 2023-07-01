import java.util.StringTokenizer;

class Solution {
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial, " + ");
        StringBuilder sb = new StringBuilder();

        int xsum = 0;
        int sum = 0;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();

            if (str.contains("x")) {
                String x = str.replace("x", "");
                System.out.println(x);
                if (x.isBlank()) {
                    xsum += 1;
                } else {
                    xsum += Integer.parseInt(x);
                }
            } else {
                sum += Integer.parseInt(str);
            }
        }

        if (xsum == 0) {
            sb.append(sum);
        } else if (sum == 0) {
            if (xsum == 1) {
                sb.append("x");
            } else {
                sb.append(xsum).append("x");
            }
        } else {
            if (xsum == 1) {
                sb.append("x").append(" + ").append(sum);
            } else {
                sb.append(xsum).append("x").append(" + ").append(sum);    
            }

        }

        return sb.toString();
    }
}