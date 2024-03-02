import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int num : queue1) {
            q1.offer(num);
            sum1 += num;
        }
        
        for (int num : queue2) {
            q2.offer(num);
            sum2 += num;
        }
        
        int cnt = 0;
        
        while (sum1 != sum2) {
            int num;
            
            if (sum1 < sum2) {
                num = q2.poll();
                q1.offer(num);
                sum1 += num;
                sum2 -= num;                
            } else if (sum1 > sum2) {
                num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;                
            }
            
            cnt++;
            
            if (cnt > (q1.size() + q2.size() - 2) * 2) return -1;
        }
        
        return cnt;
    }
}