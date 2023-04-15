class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] winNums = new boolean[46];
        for (int num : win_nums) {
            winNums[num] = true;
        }
        
        int cntRandom = 0;   // 동생의 낙서로 알아볼 수 없게 된 번호의 개    수
        int cntWin = 0;   // 민호가 맞힌 당첨 번호의 개수
        for (int num : lottos) {
            if (num == 0) cntRandom++;
            if (winNums[num]) cntWin++;
        }
                        
        int maxRank = Math.min(7 - (cntRandom + cntWin), 6);   // 당첨 가능한 최고 순위
        int minRank = Math.min(7 - cntWin, 6);   // 당첨 가능한 최저 순위
                
        return new int[]{maxRank, minRank};
    }
}