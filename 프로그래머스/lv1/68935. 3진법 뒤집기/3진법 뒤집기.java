class Solution {
    public int solution(int n) {
        // 주어진 자연수 n을 3진법으로 표현했을 때, 몇 자릿수인지 구한다
        int radix = 3, product = 1, cnt = 0;
        while (true) {
            product *= radix;
            if (product > n) break;
            cnt++;
        }
        
        // 각 자릿값을 구한 후 StringBuilder로 이어붙이면 3진법으로 표현된 수가 된다
        StringBuilder sb = new StringBuilder();        
        for (int i = cnt; i >= 0; i--) {
            sb.append(n / (int)Math.pow(radix, i));
            n -= (int)Math.pow(radix, i) * (n / (int)Math.pow(radix, i));
        }
        
        // 3진법으로 표현된 수를 반전시킨 후 다시 10진법으로 변환해서 반환한다
        return Integer.parseInt(sb.reverse().toString(), radix);
        
        
        // 아래와 같이 간단하게 풀 수 있는 문제였는데, 너무 무식한(?) 방식으로 접근했다.
        // StringBuilder sb = new StringBuilder();
        // while(n != 0) {
        //     sb.append(n%3);            
        //     n /= 3;
        // }
        // return Integer.parseInt(sb.toString(), 3);
    }
}