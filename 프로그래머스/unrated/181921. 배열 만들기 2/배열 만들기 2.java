import java.util.*;

class Solution {
    public int[] deletes = {1, 2, 3, 4, 6, 7, 8, 9};
    public int[] solution(int l, int r) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = l;i <= r;i++) {
            boolean isDelete = false;
            String value = Integer.toString(i);
            for (int delete : deletes)
                if (value.contains(Integer.toString(delete))) {
                    isDelete = true;
                    break;
                }

            if (isDelete) continue;
            arrayList.add(i);
        }       
        int idx = 0;
        int[] answer = new int[arrayList.size()];
        for (int data : arrayList)
            answer[idx++] = data;
        return arrayList.size() == 0 ? new int[] {-1} : answer;
    }
}