// 1. 양의 정수 n의 제곱근 x를 1로 나눈 나머지가 0이면, x+1의 제곱을 반환
// 2. x를 1로 나눈 나머지가 0이 아니면, -1을 반환

class Solution {
    public long solution(long n) {
        return (Math.sqrt(n) % 1 == 0)? (long)Math.pow(Math.sqrt(n) + 1, 2) : -1;
    }
}