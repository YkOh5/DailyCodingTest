class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] winNums = new boolean[46];
        for (int num : win_nums) {
            winNums[num] = true;
        }
        
        int cntRandom = 0;   // 동생의 낙서로 알아볼 수 없게 된 번호의 개수
        int cntWin = 0;   // 민호가 맞힌 당첨 번호의 개수
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) cntRandom++;
            if (winNums[lottos[i]]) cntWin++;
        }
        
        int[] answer = new int[2];
        answer[0] = (cntRandom + cntWin >= 2)? 7 - (cntRandom + cntWin) : 6;  // 최고 순위
        answer[1] = (cntWin >= 2)? 7 - cntWin : 6;   // 최저 순위
        
        return answer;
    }
}