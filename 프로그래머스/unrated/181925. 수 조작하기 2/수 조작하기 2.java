class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx < numLog.length; idx++) {
            int diff = numLog[idx] - numLog[idx - 1];            
            switch (diff) {
                case 1 -> sb.append('w');
                case -1 -> sb.append('s');
                case 10 -> sb.append('d');
                case -10 -> sb.append('a');
            }
        }

        return sb.toString();
    }
}