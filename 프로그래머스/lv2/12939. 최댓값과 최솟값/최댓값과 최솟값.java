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
        
        
        // 기초적인 방법으로 최소/최대값을 구하고, StringBuilder를 이용해서 이어붙이는 방식이 가장 빠르다
        // String[] strArr = s.split(" ");
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;        
        // for (String item : strArr) {
        //     if (Integer.parseInt(item) < min) {
        //         min = Integer.parseInt(item);
        //     }
        //     if (Integer.parseInt(item) > max) {
        //         max = Integer.parseInt(item);
        //     }
        // }        
        // StringBuffer sb = new StringBuffer();
        // sb.append(min);
        // sb.append(" ");
        // sb.append(max);        
        // return sb.toString();
        
        
        // Stream을 활용하면 처리속도는 다소 떨어지지만, 훨씬 간결하게 해결 가능
        // String[] strArr = s.split(" ");        
        // StringBuilder sb = new StringBuilder();
        // sb.append(Arrays.stream(strArr).mapToInt(Integer::parseInt).min().getAsInt());
        // sb.append(" ");
        // sb.append(Arrays.stream(strArr).mapToInt(Integer::parseInt).max().getAsInt());        
        // return sb.toString();
    }
}
