import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        int maxNum = Integer.MIN_VALUE;        
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];            
            q2.offer(queue2[i]);
            sum2 += queue2[i];            
            
            maxNum = Math.max(maxNum, Math.max(queue1[i], queue2[i]));
        }
        
        if ((sum1 + sum2) % 2 != 0 || maxNum > (sum1 + sum2) / 2) return -1;
        
        int cnt = 0;
        
        while (sum1 != sum2) {
            if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());        
            } else if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            }
            
            cnt++;
            
            if (cnt > queue1.length * 3) return -1;
        }
        
        return cnt;
    }
}