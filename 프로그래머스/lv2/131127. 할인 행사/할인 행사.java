import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++) {
            itemMap.put(want[i], number[i]);
        }

        int cnt = 0;
        for (int i = 0; i < discount.length; i++) {
            HashMap<String, Integer> clonedMap = (HashMap<String, Integer>)itemMap.clone();   
            for (int j = i; j < i + 10; j++) {
                if (j >= discount.length) continue;
                clonedMap.put(discount[j], clonedMap.getOrDefault(discount[j], 0) - 1);
            }

            boolean chk = true;
            for (int count : clonedMap.values()) {
                if (count > 0) {
                    chk = false;
                    break;
                }
            }

            if (chk) cnt++;
        }

        return cnt;
    }
}