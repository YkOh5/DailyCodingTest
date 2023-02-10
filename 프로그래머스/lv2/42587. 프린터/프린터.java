import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for (int item : priorities) {
            queue.add(item);
        }
        
        int priority = 0;
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            priority = queue.poll();
            if (priority >= queue.stream().max(Integer::compare).orElse(-1)) {
                cnt++;
            } else {
                queue.add(priority);
                if (location == 0) {
                    location = queue.size();
                }
            }
            
            location--;
            
            if (location < 0) {
                break;
            }
        }
        
        return cnt;
    }
}