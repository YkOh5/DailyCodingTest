import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleScale = new PriorityQueue<>();
        for (int scale : scoville) scovilleScale.add(scale);
        
        int cnt = 0;
        while (scovilleScale.peek() < K && scovilleScale.size() > 1) {
            int newScale = scovilleScale.remove() + scovilleScale.remove() * 2;
            scovilleScale.add(newScale);
            cnt++;
        }
        
        return (scovilleScale.peek() >= K)? cnt : -1;
    }
}