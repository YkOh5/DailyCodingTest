import java.util.*;

class Solution {
    public String solution(String s) {        
        ArrayList<Integer> list = new ArrayList<>();
        // 문자열 s를 공백을 구분자로 분할하고
        StringTokenizer st = new StringTokenizer(s, " ");
        // 정수형 래퍼 클래스로 변환한 후 ArrayList에 추가
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // 오름차순으로 정렬
        Collections.sort(list);
        // 정렬된 ArrayList의 첫 번째 원소(최소값)와 마지막 원소(최대값)을 이용해서 반환
        return String.valueOf(list.get(0)) + " " + String.valueOf(list.get(list.size()-1));
    }
}