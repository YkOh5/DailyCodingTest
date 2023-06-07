import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int cnt = 0;
        while (true) {
            int[] nextArr = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) nextArr[i] = arr[i] / 2;
                else if (arr[i] < 50 && arr[i] % 2 != 0) nextArr[i] = 2 * arr[i] + 1;
                else nextArr[i] = arr[i];
            }

            if (Arrays.equals(arr, nextArr)) {
                break;
            }

            cnt++;
            arr = nextArr;
        }        

        return cnt;
    }
}