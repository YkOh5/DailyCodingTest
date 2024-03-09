// Integer.bitCount(); 를 이용하면 더 효율적인 코드를 짤 수 있다?

import java.util.Arrays;

class Solution {
    private int[] ryanScores;
    private int maxScoreDiff = 0;
    
    public int[] solution(int n, int[] info) {
        ryanScores = new int[info.length];
        int[] targetFace = new int[info.length];
        int totalArrows = n;
        
        getTheComb(targetFace, totalArrows, 0, info);
        
        return (maxScoreDiff <= 0)? new int[]{-1} : ryanScores;
    }
    
    private void getTheComb(int[] targetFace, int arrowsLeft, int index, int[] apeachScores) {
        if (arrowsLeft == 0) {
            doScoring(targetFace, apeachScores);
            
            return;
        }

        for (int i = index; i < targetFace.length; i++) {
            if (arrowsLeft > 0 && targetFace[i] <= apeachScores[i]) {
                targetFace[i]++;
                getTheComb(targetFace, arrowsLeft - 1, i, apeachScores);
                targetFace[i]--;
            }
        }
    }
    
    private void doScoring(int[] targetFace, int[] apeachScores) {
        int rTotScore = 0;
        int aTotScore = 0;
        
        for (int i = 0; i < targetFace.length; i++) {
            if (targetFace[i] == apeachScores[i] && apeachScores[i] == 0) continue;
            
            if (targetFace[i] > apeachScores[i]) rTotScore += 10 - i;
            else aTotScore += 10 - i;
        }
        
        if (rTotScore - aTotScore > maxScoreDiff) {
            ryanScores = Arrays.copyOf(targetFace, targetFace.length);
            maxScoreDiff = rTotScore - aTotScore;
        } else if (rTotScore - aTotScore == maxScoreDiff) {            
            for (int i = targetFace.length - 1; i >= 0; i--) {
                if (ryanScores[i] == targetFace[i]) continue;
                else if (ryanScores[i] > targetFace[i]) break;
                else {
                    ryanScores = Arrays.copyOf(targetFace, targetFace.length);
                    break;
                }
            }
        }
    }
}