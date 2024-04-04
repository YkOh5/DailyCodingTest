import java.util.*;

class Solution {
    int grooveCnt = 0;
    
    public boolean solution(int[][] key, int[][] lock) {
        for (int[] row : lock) {
            for (int num : row) if (num == 0) grooveCnt++;
        }
        
        boolean validKey = false;
        
        for (int i = 0; i < 4; i++) {
            if (i > 0) key = rotateKey(key);
            if (validKey = isValidKey(key, lock)) break;
        }
        
        return validKey;
    }
    
    private int[][] rotateKey(int[][] key) {
        int[][] rotatedKey = new int[key.length][key.length];
        
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotatedKey[j][key.length - 1 - i] = key[i][j];
            }
        }
        
        return rotatedKey;
    }
    
    private boolean isValidKey(int[][] key, int[][] lock) {        
        for (int i = -(key.length - 1); i < lock.length; i++) {
            for (int j = -(key.length - 1); j < lock.length; j++) {
                int matchedCnt = 0;
                
                curLoop :
                for (int x = 0; x < key.length; x++) {
                    for (int y = 0; y < key.length; y++) {
                        if (!(0 <= x + i && x + i < lock.length) || !(0 <= y + j && y + j < lock.length)) continue;
                        if (key[x][y] == 1 && lock[x + i][y + j] == 1) break curLoop;
                        if (key[x][y] == 1 && lock[x + i][y + j] == 0) matchedCnt++;
                    }
                }
                
                if (matchedCnt == grooveCnt) return true;
            }
        }
        
        return false;
    }
}