import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = Math.min(citations.length, citations[citations.length - 1]);
        for (int i = hIndex; i >= 0; i--) {
            if (i >= 1 && citations[citations.length - i] < i) continue;
            if (citations.length - i - 1 >= 0 && citations[citations.length - i - 1] > i) continue;
            return i;
        }
        
        return 0;
    }
}


// 아래의 코드가 처리속도는 조금 더 느리지만, 보다 직관적이다
// class Solution {
//     public int solution(int[] citations) {
//         Arrays.sort(citations);  // 인용 횟수를 오름차순으로 정렬
//         int hIndex = 0;
//         for (int i = 0; i < citations.length; i++) {
//             int cnt = citations.length - i;  // 현재 인용 횟수 이상인 논문 수
//             // 인용 횟수가 현재 인용 횟수 이상인 논문이 cnt편 이상인 경우
//             if (citations[i] >= cnt) {
//                 hIndex = cnt;
//                 break;
//             }
//         }
//         return hIndex;
//     }
// }