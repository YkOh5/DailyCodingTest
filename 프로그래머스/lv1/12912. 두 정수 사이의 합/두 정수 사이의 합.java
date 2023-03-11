// 1. 자료(=Data)를 다루기 위한 자료형(Data Type)의 종류와 범위를 먼저 고려해야 한다.
// 2. int -> 크기 : 4byte(=32bit) / 범위 : -2,147,483,648(=-2^31) ~ 2,147,483,647(=2^31-1)
// 3. long -> 크기 : 8byte(=64bit) / 범위 : -2^63 ~ 2^63-1

class Solution {
    public long solution(int a, int b) {
        // a와 b의 대소를 비교하여 등차수열의 합을 구하는 함수를 호출
        return sum(Math.min(a,b), Math.max(a,b));
    }
    
    // 정수의 합이 int형의 범위를 벗어날 수 있으므로 long형태로 계산하여 반환
    public long sum(long min, long max) {
        // 등차수열의 합
        return (max - min + 1) * (min + max) / 2;
    }
}