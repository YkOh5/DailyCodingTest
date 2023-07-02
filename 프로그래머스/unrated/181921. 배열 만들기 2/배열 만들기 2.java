import java.util.stream.IntStream;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = IntStream.rangeClosed(l,r).filter(this::valid).toArray();
        return answer.length==0?new int[]{-1}:answer;
    }

    private boolean valid(int i) {
        boolean result = true;

        for(char ch: String.valueOf(i).toCharArray()) {
            if(ch != '0' && ch != '5') {
                result = false;
                break;
            }
        }

        return result;
    }
}