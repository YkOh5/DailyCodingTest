import java.util.ArrayList;

class Solution {
    public Integer[] solution(int n) {
        ArrayList<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisorList.add(i);
                if (Math.sqrt(n) != i) divisorList.add(n / i);
            }
        }
        
        divisorList.sort(null);
        
        return divisorList.toArray(new Integer[0]);
    }
}


// import java.util.ArrayList;

// class Solution {
//     public Integer[] solution(int n) {
//         ArrayList<Integer> divisorList = new ArrayList<>();
//         for (int i = 1; i <= n / 2; i++) {
//             if (n % i == 0) divisorList.add(i);
//         }

//         divisorList.add(n);

//         return divisorList.toArray(new Integer[0]);
//     }
// }