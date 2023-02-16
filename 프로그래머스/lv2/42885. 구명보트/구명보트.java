// 1. 고립된 사람들을 체중의 오름차순으로 정렬
// 2. 최저 체중과 최대 체중의 합이 중량 제한 이하이면, 2명에게 구명보트 한 척을 배정
// 3. 합이 중량 제한을 초과하면, 최대 체중인 사람 1명에게 구명보트 한 척을 배정

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 최대 탑승인원이 2명인 점을 고려하여 Two-Pointers 알고리즘을 이용
        int p1 = 0;
        int p2 = people.length - 1;
        
        int cnt = 0;
        // 체중을 오름차순으로 정렬
        Arrays.sort(people);
        
        while (p1 <= p2) {
            // 최저 체중(=people[p1])과 최대 체중(=people[p2])의 합을 중량 제한(=limit) 비교
            // 합이 중량 제한 이하이면, 2명에게 구명보트 한 척을 배정
            if (people[p1] + people[p2] <= limit) {
                cnt++;
                p1++;
                p2--;
            // 합이 중량 제한을 초과하면, 최대 체중인 사람 1명에게 구명보트 한 척을 배정
            } else {
                cnt++;
                p2--;
            }
        }
        
        return cnt;
    }
}