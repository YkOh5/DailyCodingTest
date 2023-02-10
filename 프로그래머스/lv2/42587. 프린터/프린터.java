// 1. 중요도가 존재하지만 기본적으로는 선입선출의 구조이므로 Queue를 이용
// 2. 모든 인쇄작업의 중요도를 Queue에 추가하고, 하나씩 뽑아내서(대기 위치 - 1) 최고 중요도와 비교
// 3. 해당 작업의 중요도가 가장 높으면 인쇄 횟수 + 1
// 4. 가장 높지 않으면 Queue에 다시 추가, 이 때 대기 위치 = 0 이었다면 대기열 끝으로 갱신 (location = Queue.size())
// 5. 대기 위치 < 0 이면, 인쇄 횟수를 반환

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> print = new LinkedList<>();
        for (int item : priorities) {
            print.add(item);
        }
        
        int cnt = 0;        
        while (!print.isEmpty()) {
            int priority = print.poll();
            // 현재 작업의 중요도가 가장 높은 경우 인쇄 횟수 + 1
            if (priority >= print.stream().max(Integer::compare).orElse(-1)) {
                cnt++;
            // 가장 높지 않은 경우 대기열 끝에 다시 추가
            } else {
                print.add(priority);
                // 해당 작업물이 인쇄를 요청한 문서인 경우 대기 위치를 대기열 끝으로 갱신
                if (location == 0) {
                    location = print.size();
                }
            }
            
            // 다른 작업물이 인쇄가 되든 대기열 끝으로 밀리든 요청한 문서의 대기 위치는 앞으로 이동
            location--;
            // 요청한 문서가 인쇄된 경우
            if (location < 0) {
                break;
            }
        }        
        return cnt;
    }
}