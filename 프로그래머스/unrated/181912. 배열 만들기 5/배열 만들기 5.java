import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (String intStr : intStrs) {
            int result = Integer.parseInt(intStr.substring(s, s + l));
            if (result > k)
                arrayList.add(result);
        }

        int idx = 0;
        int[] answer = new int[arrayList.size()];
        for (int data : arrayList)
            answer[idx++] = data;
        return answer;
    }
}