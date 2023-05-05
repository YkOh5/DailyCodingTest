import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> discountedMap = new HashMap<>();
        int membershipDuration = 10;
        int cnt = 0;
        for (int i = 0; i < membershipDuration; i++) {
            discountedMap.put(discount[i], discountedMap.getOrDefault(discount[i], 0) + 1);
        }
        if(isValidPeriod(want, number, discountedMap)) cnt++;
        
        for (int i = membershipDuration; i < discount.length; i++) {
            discountedMap.put(discount[i - membershipDuration], discountedMap.getOrDefault(discount[i - membershipDuration], 0) - 1);
            discountedMap.put(discount[i], discountedMap.getOrDefault(discount[i], 0) + 1);
            
            if(isValidPeriod(want, number, discountedMap)) cnt++;
        }        
        
        return cnt;
    }
    
    private boolean isValidPeriod(String[] want, int[] number, HashMap<String, Integer> discountedMap) {
        for (int i = 0; i < want.length; i++) {
            if (discountedMap.getOrDefault(want[i], 0) < number[i]) return false;
        }
        
        return true;
    }
}


// 아래의 코드는 불필요한 반복 때문에 처리속도가 매우 떨어진다
// import java.util.HashMap;
// class Solution {
//     public int solution(String[] want, int[] number, String[] discount) {
//         HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
//         for (int i = 0; i < want.length; i++) {
//             itemMap.put(want[i], number[i]);
//         }
//         int cnt = 0;
//         for (int i = 0; i < discount.length; i++) {
//             HashMap<String, Integer> clonedMap = (HashMap<String, Integer>)itemMap.clone();   
//             for (int j = i; j < i + 10; j++) {
//                 if (j >= discount.length) continue;
//                 clonedMap.put(discount[j], clonedMap.getOrDefault(discount[j], 0) - 1);
//             }
//             boolean flag = true;
//             for (String key : itemMap.keySet()) {
//                 if (clonedMap.get(key) > 0) {
//                     flag = false;
//                     break;
//                 }
//             }
//             if (flag) cnt++;
//         }
//         return cnt;
//     }
// }


// 아래와 같은 방식의 코드가 간결하고, 처리속도도 훨씬 빠르다
// class Solution {
//        static public int solution(String[] want, int[] number, String[] discount) {
//         int registratableDays = 0;   // 주어진 조건을 만족하는 회원등록이 가능한 날짜의 총 일수
//         int membershipDuration = 10;   // 회원자격 유지 기간           
//         // 할인기간 내에서
//         for(int i = 0; i <= discount.length - membershipDuration; i++) {
//             boolean isValidPeriod = true;
//             // 구매하기를 원하는 제품과
//             for(int j = 0; j < want.length; j++) {
//                 int cnt = 0;
//                 // 회원자격 유지 기간 동안
//                 for(int k = i; k < i + membershipDuration; k++) {
//                     // 할인하는 제품이 일치하는 경우
//                     if(discount[k].equals(want[j])) cnt++;   // 해당 제품에 대한 구매가능 횟수 증가
//                 }
//                 // 원하는 제품을 모두 구매할 수 없는 경우
//                 if(cnt < number[j]) {
//                     isValidPeriod = false;
//                     break;   
//                 }            
//             }
//             // 구매할 수 있는 경우
//             if(isValidPeriod) registratableDays ++;
//         }           
//         return registratableDays;
//     }
// }