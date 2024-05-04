import java.util.*;

class Solution {    
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> stack = new Stack<>();
        for (String cmd: cmds) {
            StringTokenizer st = new StringTokenizer(cmd);
            String cmdType = st.nextToken();
            int d = 0;
            if (st.hasMoreTokens()) d = Integer.parseInt(st.nextToken());
            
            switch (cmdType) {
                    case "U" -> k -= d;
                    case "D" -> k += d;
                    case "C" -> { 
                        stack.push(k);
                        n--;
                        if (k >= n) k--;
                    }
                    case "Z" -> {
                        if (stack.pop() <= k) k++;
                        n++;                        
                    }
            }            
        }
                
        StringBuilder sb = new StringBuilder("O".repeat(n));
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }
        
        return sb.toString();
    }
}