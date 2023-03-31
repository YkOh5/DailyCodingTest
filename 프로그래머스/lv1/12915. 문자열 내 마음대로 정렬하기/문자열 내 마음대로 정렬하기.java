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
        
        
        // Method Overriding을 적절히 활용하면 한 번의 정렬만으로 원하는 결과를 얻을 수 있다
        // Arrays.sort(strings, new Comparator<String>(){            
        //     @Override
        //     public int compare(String s1, String s2){
        //         if (s1.charAt(n) == s2.charAt(n)) { 
        //             return s1.compareTo(s2);
        //         }
        //         return s1.charAt(n) - s2.charAt(n);
        //     }
        // });
        // return strings;
        
        
        // 이중반복문을 이용해서 정렬을 직접 구현하는 방식의 처리속도가 훨씬 빠르다
        // for (int i = 0; i < strings.length - 1; i++) {            
        //     for (int j = i + 1; j < strings.length; j++) {                
        //         if (strings[i].charAt(n) > strings[j].charAt(n)) {
        //             String tmp = strings[i];
        //             strings[i] = strings[j];
        //             strings[j] = tmp;
        //         } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
        //             if (strings[i].compareTo(strings[j]) > 0) {
        //                 String tmp = strings[i];
        //                 strings[i]= strings[j];
        //                 strings[j]=tmp;
        //             }
        //         }
        //     }
        // }
        // return strings;
    }
}
