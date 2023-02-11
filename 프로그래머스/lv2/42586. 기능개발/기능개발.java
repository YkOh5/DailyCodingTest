// 1. 개발 기간 = ((100 - 작업 진도) / 개발 속도)의 올림값 
// 2. 각 작업에 대한 개발 기간을 Queue에 추가
// 3. Queue의 원소를 하나 추출
// 4. 다음 원소의 값이 처음 뽑은 원소의 값보다 작거나 같으면 계속해서 추출
// 5. 추출된 원소들의 개수(=배포 1회당 기능의 개수)를 ArrayList에 저장
// 6. Queue가 소진될 때까지 3~5과정을 반복한 후, ArrayList를 Array로 변환하여 반환

import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        // 작업물이 순서대로 배포되므로 선입선출의 Queue를 이용
        Queue<Integer> devPeriod = new LinkedList<>();
        
        // 개발 기간 = ((100 - 작업 진도) / 개발 속도)의 올림값
        for (int i = 0; i < progresses.length; i++) {
            devPeriod.add((int)Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
                
        while(!devPeriod.isEmpty()) {
            // 배포 1회당 기능의 개수            
            int cnt = 0;
            // 배포 시 첫 작업의 개발 기간
            int days = 0;
            
            days = devPeriod.poll();
            cnt++;
            
            // 후속 작업의 개발 기간이 첫 작업의 개발 기간보다 짧으면 배포에 포함
            while(!devPeriod.isEmpty() && days >= devPeriod.peek()) {
                devPeriod.poll();
                cnt++;
            }
            
            list.add(cnt);
        }
        
        return list.toArray(new Integer[list.size()]);
    }
}