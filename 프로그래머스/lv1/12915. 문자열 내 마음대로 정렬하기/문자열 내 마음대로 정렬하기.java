import java.util.Arrays;
// import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 우선 주어진 문자열 배열 strings를 오름차순으로 정렬
        Arrays.sort(strings);
        // 각 원소의 n번째 인덱스에 위치한 문자를 기준으로 오름차순으로 재정렬
        Arrays.sort(strings, (s1, s2) -> s1.charAt(n) - s2.charAt(n));
        
        
        // 아래와 같이 Comparator를 사용한 코드를 lambda를 사용해서 위와 같이 단순화 할 수 있다
        // Arrays.sort(strings, new Comparator<String>() {
        //     @Override
        //     public int compare(String str1, String str2) {
        //         return str1.charAt(n) - str2.charAt(n);
        //     }
        // });        
        
        return strings;
    }
}