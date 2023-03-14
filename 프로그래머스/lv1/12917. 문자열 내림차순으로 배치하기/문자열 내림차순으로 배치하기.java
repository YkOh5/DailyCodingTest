import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열을 공백을 구분자로 써서 분할하고, 배열에 저장
        String[] str = s.split("");
        // 문자열 배열을 내림차순으로 정렬
        Arrays.sort(str, Collections.reverseOrder());
        // 배열의 원소들을 공백을 구분자로 써서 이어붙임
        return String.join("", str);
        
        
        // Stream을 잘 활용하면 한 줄로도 해결 가능
        // return Arrays.stream(s.split(""))
        //     .sorted(Collections.reverseOrder())
        //     .collect(Collectors.joining(""));
    }
}