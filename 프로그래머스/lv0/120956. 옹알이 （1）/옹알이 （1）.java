import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(String[] babblings) {
        HashSet<String> validBabblings = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));
        int cnt = 0;
        for (String babbling : babblings) {
            StringBuilder sb = new StringBuilder();
            for (char alphabet : babbling.toCharArray()) {
                sb.append(alphabet);
                if (validBabblings.contains(sb.toString())) sb.setLength(0);
            }
            if (sb.length() == 0) cnt++;
        }
        
        return cnt;
    }
}