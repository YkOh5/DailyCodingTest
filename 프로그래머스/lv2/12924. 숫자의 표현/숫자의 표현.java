// 1. 이중반복문을 쓰면 시간복잡도가 O(n^2)이 되어 효율성이 떨어지므로
// 2. 1부터 해당 원소의 인덱스까지 연속한 자연수들의 합을 원소로 갖는 배열과 Two-Pointers 알고리즘을 이용
// 3. 배열의 마지막 원소를 n/2 + 1로 설정하면, n으로 설정했을 때보다 더 효율적
// 4. 단, n이 1이나 2일 때는 별도의 처리가 필요

class Solution {
    public int solution(int n) {
        // 1부터 해당 원소의 인덱스까지 연속한 자연수들의 합을 원소로 갖는 배열
        int[] sums = new int[n/2 + 2];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + i;
        }
        
        int p1 = 0;
        int p2 = 1;        
        int sum = 0;
        int cnt = 0;
        
        // Two-Pointers를 이용
        while (p2 < sums.length && p1 <= p2) {
            // p1 + 1부터 p2까지의 합이
            sum = sums[p2] - sums[p1];
            // n과 같을 때
            if (sum == n) {
                cnt++;  // 반환값 증가
                p1++;   // p1 이동
            // n보다 작을 때
            } else if (sum < n) {
                p2++;   // p2 이동
            // n보다 클 때
            } else {
                p1++;   // p1 이동
            }
        }
        
        //  n이 1이나 2일 때 반환값 = 1
        if (n < 3) {
            return 1;
        // n/2 + 1까지만 세었으므로, p1=p2=n인 경우의 수 1을 더해서 반환
        } else {
            return cnt + 1;            
        }        
    }
}