import java.util.*;

class Solution {
    public long solution(long n) {
        // 정수 n의 각 자릿값을 원소로 갖는 문자열 배열 생성
        String[] strArr = String.valueOf(n).split("");
        
        // 내림차순으로 정렬
        Arrays.sort(strArr, Collections.reverseOrder());
        
        // 해당 배열의 각 원소들을 StringBuilder의 append 함수로 이어붙임
        StringBuilder sb = new StringBuilder();        
        for (String item : strArr) {
            sb.append(item);
        }
        
        // StringBuilder를 String으로 변환한 것을 다시 Long으로 변환 후 반환
        return Long.parseLong(sb.toString());
    }
}