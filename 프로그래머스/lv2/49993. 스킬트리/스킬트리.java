import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        ArrayList<Character> skillList = new ArrayList<Character>();
        for (char c : skill.toCharArray()) {
            skillList.add(c);
        }
        
        int cnt = 0;
        for (String skillTree : skill_trees) {
            ArrayList<Character> copiedSkillList = new ArrayList<>(skillList);
            boolean isValid = true;
            for (char c : skillTree.toCharArray()) {
                if (copiedSkillList.isEmpty()) break;
                
                if (c == copiedSkillList.get(0)) copiedSkillList.remove(0);
                else if (copiedSkillList.contains(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) cnt++;
        }
        
        return cnt;
    }
}