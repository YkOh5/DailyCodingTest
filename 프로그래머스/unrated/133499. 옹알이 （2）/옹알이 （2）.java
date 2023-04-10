class Solution {
    public int solution(String[] babbling) {
        // 머쓱이의 조카가 발음할 수 있는 단어들
        String[] validWords = {"aya", "ye", "woo", "ma"};
        int cnt = 0;
        // 배열 babbling의 모든 원소에 대해서
        for (int i = 0; i < babbling.length; i++) {            
            for (String word : validWords) {
                // 유효단어가 연속적으로 나타나지 않는 경우에만 해당 단어를 공백으로 대체
                if (!babbling[i].contains(word.repeat(2))) babbling[i] = babbling[i].replace(word, " ");
            }
            // 공백을 제거
            babbling[i] = babbling[i].replace(" ", "");
            // 해당 원소의 길이가 0이면 반환값 증가
            if (babbling[i].length() == 0) cnt++;
        }
        
        return cnt;
    }
}