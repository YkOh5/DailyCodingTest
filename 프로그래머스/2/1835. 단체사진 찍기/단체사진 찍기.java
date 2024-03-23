import java.util.*;

class Solution {
    private String[] data;
    private int cnt = 0;    
    
    public int solution(int n, String[] data) {
        char[] kakaoFriends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        char[] output = new char[kakaoFriends.length];
        boolean[] visited = new boolean[kakaoFriends.length];
        
        this.data = data;
        
        countValidPerm(kakaoFriends, output, visited, 0);
        
        return cnt;
    }
    
    private void countValidPerm(char[] input, char[] output, boolean[] visited, int depth) {
        if (depth == input.length) {
            if (validPerm(output)) cnt++;
            
            return;
        }
        
        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                countValidPerm(input, output, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean validPerm(char[] perm) {
        HashMap<Character, Integer> posMap = new HashMap<>();
        
        for (int i = 0; i < perm.length; i++) {
            posMap.put(perm[i], i);
        }
        
        for (String cond : data) {
            int d1 = Math.abs(posMap.get(cond.charAt(0)) - posMap.get(cond.charAt(2)));
            int d2 = Character.getNumericValue(cond.charAt(4)) + 1;
            char op = cond.charAt(3);
            
            if (op == '=' && d1 != d2) return false;
            else if (op == '<' && d1 >= d2) return false;
            else if (op == '>' && d1 <= d2) return false;            
        }
        
        return true;
    }
}