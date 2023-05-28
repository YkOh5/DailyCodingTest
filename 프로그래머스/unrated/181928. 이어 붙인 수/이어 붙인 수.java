class Solution {
    public int solution(int[] num_list) {
        int oddConcat = 0;
        int evenConcat = 0;
        
        for (int num : num_list) {
            if (num % 2 != 0) oddConcat = 10 * oddConcat + num;
            else evenConcat = 10 * evenConcat + num;
        }
        
        return oddConcat + evenConcat;
    }
}


// class Solution {
//     public int solution(int[] num_list) {
//         StringBuilder sbOdd = new StringBuilder();
//         StringBuilder sbEven = new StringBuilder();
        
//         for (int num : num_list) {
//             if (num % 2 != 0) sbOdd.append(num);
//             else sbEven.append(num);
//         }        
        
//         return Integer.parseInt(sbOdd.toString()) + Integer.parseInt(sbEven.toString());
//     }
// }