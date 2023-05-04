// 최소공배수 = arr의 모든 원소들의 곱(공배수)의 약수들 중에서 각 숫자로 나눠떨어지는 가장 작은 수

class Solution {
    public int solution(int[] arr) {
        long product = 1;   // 모든 원소들의 곱(공배수)
        for (int num : arr) {
            product *= num;
        }
        
        for (int i = 1; i <= product; i++) {   // 모든 원소들의 곱의
            if (product % i != 0) continue;   // 약수들 중에서
            
            boolean isLCM = true;
            for (int num : arr) {   // 각 숫자들로
                if (i % num != 0) {   // 나눠떨어지지 않는 경우
                    isLCM = false;
                    break;
                }
            }
            
            if (isLCM == true) return i;   // 나눠떨어지는 경우
        }
        
        return -1;
    }
}


// 약수들을 찾는 과정을 최적화해서 별개의 반목문으로 시행하는 방식
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public int solution(int[] arr) {
//         long product = 1;
//         for (int num : arr) {
//             product *= num;
//         }        
//         ArrayList<Long> list = new ArrayList<>();
//         int idx = 0;
//         for (long i = 1; i * i <= product; i++) {
//             if (product % i == 0) {
//                 list.add(idx, i);                
//                 list.add(list.size() - idx, product / i);
//                 idx++;
//             }
//         }        
//         for (long divisor : list) {
//             boolean isLCM = true;
//             for (int num : arr) {
//                 if (divisor % num != 0) {
//                     isLCM = false;
//                     break;
//                 }
//             }
//             if (isLCM == true) return (int)divisor;
//         }        
//         return 1;
//     }
// }