// 문제의 핵심 : 다리 길이만큼의 트럭이 동시에 다리를 지날 수 있고, 다리를 지나는데 다리 길이만큼의 시간이 필요

// 1. 선입선출의 구조이므로 Queue를 이용 
// 2. 시간의 흐름에 따른 반복문에 대해서
// 3. 다리(Queue)를 지나는 트럭의 수(Queue.size())가 다리의 최대 적재량(bridge_length)보다 작고,
//    다리를 지나는 트럭의 총중량(totalWeight)이 다리가 견딜 수 있는 최대 중량(weight)보다 크지 않을 때,
//    각 트럭의 중량과 다리에 올라간 시간을 짝지어서 Queue에 추가 -> Queue.add(new Truck(w, t))
// 4. 현재 시간 >= 트럭이 다리에 투입된 시간(Queue.poll.t) + 다리를 지나가는 시간(bridge_length)일 때,
//    해당 트럭의 중량(Queue.poll().w)을 다리를 지나는 트럭의 총중량(totalWeight)에서 차감
// 5. 대기 중인 트럭이 없고(idx == truck_weights.length), 모든 트럭이 다리를 지났(Queue.isEmpty())을 때,
//    현재 시간을 반환

// 실제 코드에서는 4~6 과정을 역순으로 구현해야 아귀가 맞다.

import java.util.*;


public class Truck {
    int w;   // 다리를 지나는 트럭의 무게
    int t;   // 트럭이 다리에 올라간 시간
    
    public Truck (int w, int t) {
        this.w = w;
        this.t = t;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // Queue를 다리라고 가정
        Queue<Truck> bridge = new LinkedList<>();
        
        int idx = 0;        
        int totalWeight = 0;   // 다리를 지나는 트럭의 총 중량
        
        for (int time = 0; time <= bridge_length * truck_weights.length + 1; time++) {
            // 대기 중인 트럭이 없고, 모든 트럭이 다리를 지났을 때
            if (idx == truck_weights.length && bridge.isEmpty()) {
                return time;
            }
            
            // 특정 트럭이 다리를 지났을 때
            if (!bridge.isEmpty() && time >= bridge.peek().t + bridge_length) {                
                // 다리를 건너는 트럭의 총중량에서 해당 트럭의 중량을 차감
                totalWeight -= bridge.poll().w;
            }
            
            // 다리를 지나는 트럭의 수가 다리의 길이보다 작고            
            if (bridge.size() < bridge_length && idx < truck_weights.length
                // 다음 트럭이 다리에 올라가도 다리가 견딜 수 있을 때
                && totalWeight + truck_weights[idx] <= weight) {
                // 트럭이 다리에 오르고
                bridge.add(new Truck(truck_weights[idx], time));
                // 다리를 건너는 트럭의 총중량을 갱신
                totalWeight += truck_weights[idx];                
                idx++;
            }
                    
        }
                
        return -1;
    }
}