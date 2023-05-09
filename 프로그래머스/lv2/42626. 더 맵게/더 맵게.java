// PriorityQueue에 스코빌 지수를 추가하는 방식은 매번 시간복잡도가 O(logN)인 Heap을 사용하므로, 총 시간복잡도 = O(N*logN)

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


// List에 스코빌 지수를 추가하는 방식은 매번 시간복잡도가 O(N*logN)인 정렬을 반복해야 하므로, 총 시간복잡도 = O(N^2*logN)
// PriorityQueue를 사용한 방식에 비해 훨씬 처리속도가 떨어지므로, 효율성 테스트 실패

// import java.util.ArrayList;
// import java.util.Collections;

// class Solution {
//     public int solution(int[] scoville, int K) {
//         ArrayList<Integer> scovilleScale = new ArrayList<>();
//         for (int scale : scoville) scovilleScale.add(scale);
        
//         int cnt = 0;
//         Collections.sort(scovilleScale);
//         while (scovilleScale.get(0) < K && scovilleScale.size() >= 2) {
//             scovilleScale.add(scovilleScale.get(0) + scovilleScale.get(1) * 2);
//             scovilleScale.remove(0);
//             scovilleScale.remove(0);
//             cnt++;
//             Collections.sort(scovilleScale);
//         } 

//         return (scovilleScale.get(0) >= K)? cnt : -1;
//     }
// }