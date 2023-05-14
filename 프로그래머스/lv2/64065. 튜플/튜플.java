import java.util.ArrayList;
import java.util.HashSet;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length() - 1; i++) {
            if (Character.isDigit(s.charAt(i))) sb.append(s.charAt(i));
            else if (Character.isDigit(s.charAt(i - 1)) && s.charAt(i) == ',') {
                set.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
                
            else if (s.charAt(i) == '}') {
                set.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
                list.add(set);
                set = new HashSet<>();
            }
        }

        list.sort(Comparator.comparing(HashSet::size));
        
        int[] answer = new int[list.get(list.size() - 1).size()];
        int idx = 0;
        set = new HashSet<>(); 
        
        for (HashSet<Integer> nums : list) {
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                    answer[idx++] = num;
                }
            }
        }
        
        return answer;
    }
}
