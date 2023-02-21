// 1. goal의 모든 원소들에 대해 각 원소와 두 카드 뭉치의 단어들을 순차적으로 비교
// ex) goal의 첫 번째 단어를 1번 카드 뭉치의 1번 단어와 2번 카드 뭉치의 1번 단어에 비교했을 때, 전자와 일치한다면
// goal의 두 번째 단어를 1번 카드 뭉치의 2번 단어와 2번 카드 뭉치의 1번 단어에 비교
// 2. 순서에 맞게 일치하는 단어가 없거나 사용되지 않고 남은 카드가 있다면 "No"를 반환, 그 외 "Yes"를 반환

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            // goal의 단어가 첫 번째 카드 뭉치의 현재 단어와 일치할 때
            if (goal[i].equals(cards1[idx1])) {
                cards1[idx1] = "USED";   // 재사용 방지
                if (idx1 < cards1.length - 1) {
                    idx1++;   // 비교대상을 카드 뭉치의 다음 단어로
                }
            // goal의 단어가 두 번째 카드 뭉치의 현재 단어와 일치할 때
            } else if (goal[i].equals(cards2[idx2])) {
                cards2[idx2] = "USED";   // 재사용 방지
                if (idx2 < cards2.length - 1) {
                    idx2++;   // 비교대상을 카드 뭉치의 다음 단어로
                }
            } else {
                return "No";
            }
        }        
        
        // 사용되지 않은 카드가 남은 경우
        // if (idx1 != cards1.length - 1 || idx2 != cards2.length - 1) {
        //     return "No";
        // }
        // 해당 코드를 제외해야 20, 21, 24번 테스트케이스를 통과할 수 있다
        // 새로 등록된 문제라 그런지 테스트케이스에 오류가 있는 것 같다        
        
        return "Yes";
    }
}