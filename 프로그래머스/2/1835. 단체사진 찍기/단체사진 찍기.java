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
            if (isValidPerm(output)) cnt++;
            
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
    
    private boolean isValidPerm(char[] perm) {
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




// 유효한 순열인지 확인하는 함수에서 굳이 HashMap을 쓸 필요는 없었다
// 아래와 같이 String.indexOf()를 활용하면 더 효율적인 코드를 작성할 수 있다

// private boolean isValidPerm(char[] perm) {    
//     String str = new String(perm);
    
//     for (String cond : data) {
//         int d1 = Math.abs(str.indexOf(cond.charAt(0)) - str.indexOf(cond.charAt(2)));
//         int d2 = Character.getNumericValue(cond.charAt(4)) + 1;
//         char op = cond.charAt(3);
            
//         if ((op == '=' && d1 != d2) || (op == '<' && d1 >= d2) || (op == '>' && d1 <= d2))
//             return false;
//     }
    
//     return true;
// }