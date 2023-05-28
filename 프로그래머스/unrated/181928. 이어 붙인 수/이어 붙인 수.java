class Solution {
    public int solution(int[] num_list) {
        StringBuilder sbOdd = new StringBuilder();
        StringBuilder sbEven = new StringBuilder();
        
        for (int num : num_list) {
            if (num % 2 != 0) sbOdd.append(num);
            else sbEven.append(num);
        }        
        
        return Integer.parseInt(sbOdd.toString()) + Integer.parseInt(sbEven.toString());
    }
}