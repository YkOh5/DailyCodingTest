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
        
        // Collections 프레임워크를 사용하지 않고, 아래와 같이 오름차순으로 정렬 후
        // 반환 시에 역순으로 변환해서 반환하는 방식이 더 빠르다.
        // String[] strArr = String.valueOf(n).split("");
        // Arrays.sort(strArr);
        // StringBuilder sb = new StringBuilder();        
        // for (String item : strArr) {
        //     sb.append(item);
        // }
        // return Long.parseLong(sb.reverse().toString());
    }
}