import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int maxCnt = 0, domNum = 1;
        for (int number : array) {
            cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
            
            int cnt = cntMap.get(number);
            if (cnt > maxCnt) {
                domNum = number;
                maxCnt = cnt;
            } else if (cnt == maxCnt) domNum = -1;
        }
        
        return domNum;
    }
}



// 입력값 중 중복되는 값들이 많을 때는 아래와 같은 코드가 더 유용하다.
// import java.util.HashMap;

// class Solution {
//     private HashMap<Integer, Integer> cntMap = new HashMap<>();

//     public int solution(int[] array) {
//         for (int number : array) {
//             cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
//         }

//         return getDominantNumber();
//     }

//     private int getDominantNumber() {
//         int maxCnt = 0;
//         int domNum = -1;
//         for (int key : cntMap.keySet()) {
//             int cnt = cntMap.get(key);
//             if (cnt > maxCnt) {
//                 domNum = key;
//                 maxCnt = cnt;
//             } else if (cnt == maxCnt) domNum = -1;
//         }

//         return domNum;
//     }
// }