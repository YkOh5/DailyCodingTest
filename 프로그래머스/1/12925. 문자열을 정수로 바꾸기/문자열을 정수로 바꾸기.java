class Solution {
    public int solution(String s) {
        int answer;
        if (s.charAt(0) == '+') answer = Integer.parseInt(s.substring(1));
        else answer = Integer.parseInt(s);
        
        return answer;
    }
}



// // 문자열을 정수로 반환하는 함수 : Integer.parseInt() vs Integer.valueOf()
// // 1. parseInt() : 결과값을 항상 int 형으로 반환 -> 객체가 아닌 기본 자료형(Primitive Type)
// // 2. valueOf() : 문자열의 값을 정수형으로 변환한 다음 Integer 객체로 만들어서 반환 -> new Integer(Integer.parseInt(s))
// // 3. Java 1.5에서 도입된 'Autoboxing and Unboxing' 기능 때문에 무엇을 사용하든 결과는 같다.
// // 4. 일반적으로는 parseInt()가 더 나은 성능을 보이지만, 동일한 값에 대해 반복적인 호출이 있는 경우 캐시된 Integer 객체를 반환하는 Integer.valueOf()가 더 나은 성능을 보일 수 있다.

// class Solution {
//     public int solution(String s) {
//         // Java 내장함수를 이용
//         // return Integer.parseInt(s);
        
//         int result = 0;
        
//         // 첫 번째 문자가 숫자인 경우
//         if (Character.isDigit(s.charAt(0))) {
//             for (int i = 0; i < s.length(); i++) {
//                  result = result * 10 + Character.getNumericValue(s.charAt(i));
//             }
//         // 첫 번째 문자가 부호인 경우
//         } else {
//             for (int i = 1; i < s.length(); i++) {
//                  result = result * 10 + Character.getNumericValue(s.charAt(i));
//             }
//         }
        
//         // 첫 문자가 '-' 인 경우 음수로 반환
//         return (s.charAt(0) == '-')? result * -1 : result;
//     }
// }