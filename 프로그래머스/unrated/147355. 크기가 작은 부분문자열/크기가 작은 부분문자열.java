// 제한사항에 따르면 p는 최대 18자리의 숫자이므로 int형의 범위(-2*10^9 ~ +2*10^9 = 약 +-21억)를 벗어난다
// 따라서 p를 감당할 수 있는 범위(-9*10^18 ~ +9*10^18 = 약 +-900경)를 갖는 long형을 써야 한다

class Solution {
    public int solution(String t, String p) {
        // 처리속도 높이기 위해 StringBuilder를 사용하고
        StringBuilder sb = new StringBuilder(t);
        // 문자열 p의 정수형 값도 반복문 밖에서 미리 정의해둔다
        long longP = Long.parseLong(p);
        int cnt = 0;
        
        for (int i = 0; i <= sb.length() - p.length(); i++) {
            // t에 대한 부분문자열의 정수형 값이 p의 정수형 값보다 작은 경우
            if (Long.parseLong(sb.substring(i, i + p.length())) <= longP) cnt++;
        }
        
        return cnt;
    }
}