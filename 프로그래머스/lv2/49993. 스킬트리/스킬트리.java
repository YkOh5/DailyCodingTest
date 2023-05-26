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


// String.indexOf() 함수를 이용하면 더 간단하고 효율적인 코드를 작성할 수 있다
// 해당 함수는 문자열이 특정 문자를 포함하지 않을 경우 -1을 반환한다
// class Solution {
//     public int solution(String pre_requisite_skills, String[] skill_trees) {
//         int cnt = 0;        
//         for (String skill_tree : skill_trees) {
//             int targetIdx = 0;
//             boolean validSkillTree = true;            
//             for (char skill : skill_tree.toCharArray()) {
//                 int skillIdx = pre_requisite_skills.indexOf(skill);                
//                 if (skillIdx == -1) continue;
//                 else if (skillIdx == targetIdx) targetIdx++;
//                 else {
//                     validSkillTree = false;
//                     break;
//                 }
//             }            
//             if (validSkillTree) cnt++;
//         }        
//         return cnt;
//     }
// }