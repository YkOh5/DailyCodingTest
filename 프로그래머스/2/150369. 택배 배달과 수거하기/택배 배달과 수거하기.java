class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long minDistance = 0;
        int dvIdx = n - 1;
        int puIdx = n - 1;
        int dvLastTaskIdx = getLastTaskIdx(deliveries);
        int puLastTaskIdx = getLastTaskIdx(pickups);

        while (deliveries[dvLastTaskIdx] > 0 || pickups[puLastTaskIdx] > 0) {
            dvIdx = findTargetIdx(deliveries, dvIdx);
            puIdx = findTargetIdx(pickups, puIdx);

            minDistance += Math.max(dvIdx + 1, puIdx + 1) * 2;
            
            deliverAndPickup(deliveries, dvIdx, cap);
            deliverAndPickup(pickups, puIdx, cap);
        }

        return minDistance;
    }

    private int getLastTaskIdx(int[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] > 0) return i;
        }
        
        return 0;
    }
    
    private int findTargetIdx(int[] tasks, int location) {
        for (int i = location; i >= 0; i--) {
            if (tasks[i] > 0 || i == 0) {
                return i;
            }
        }
        
        return location;
    }

    private void deliverAndPickup(int[] tasks, int location, int capacity) {
        int count = 0;
        
        while (count < capacity && location >= 0) {
            int temp = Math.min(tasks[location], capacity - count);
            tasks[location] -= temp;
            count += temp;
            if (tasks[location] == 0) location--;
        }
    }
}



// 문제를 잘 파악하면 훨씬 더 간단하고 효율적인 코드를 구현할 수 있다!!!
// class Solution {
//     public long solution(int cap, int n, int[] deliveries, int[] pickups) {
//         long minDistance = 0;
//         int deliver = 0, pickup = 0;
        
//         for(int i = n - 1; i >= 0; i--){
//             deliver += deliveries[i];
//             pickup += pickups[i];
            
//             while (deliver > 0 || pickup > 0){
//                 deliver -= cap;
//                 pickup -= cap;
                
//                 minDistance += (i + 1) * 2;
//             }

//         }
        
//         return minDistance;
//     }
// }