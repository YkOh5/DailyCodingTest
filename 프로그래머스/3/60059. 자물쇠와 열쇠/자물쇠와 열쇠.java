class Solution {
    int n, m;
    public boolean solution(int[][] key, int[][] lock) {
       m = key.length;
        n = lock.length;

        int hom = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(lock[i][j] == 0) hom++;
            }
        }

        for(int roll = 0; roll < 4; roll++) {    
            for(int v = -m+1; v < n; v++) {     //수직 이동
                for(int h = -m+1; h < n; h++) { //수평 이동   
                    int cnt = 0;
                    for(int i = 0; i < m; i++) {  
                        if(i+v < 0 || i+v >= n) continue;
                        for(int j = 0; j < m; j++) {
                            if(j+h < 0 || j+h >= n) continue;
                            if(lock[i+v][j+h] == 0) cnt++;
                        }
                    }

                    if(cnt != hom) continue;
                    boolean flag = true;
                    for(int i = 0; flag && i < m; i++) {  
                        if(i+v < 0 || i+v >= n) continue;
                        for(int j = 0; flag && j < m; j++) {
                            if(j+h < 0 || j+h >= n) continue;
                            if(key[i][j] + lock[i+v][j+h] != 1) {
                                flag = false;
                                break;
                            }
                        }
                    }                   
                    if(flag) return true;
                }
            }
            key = spin(key);
        }
        return false;
    }

    public boolean check(int[][] lock, int[][] key) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(lock[i][j] + key[i][j] != 1) return false;
            }
        }
        return true;
    }

    public int[][] spin(int[][] a) {
        int[][] b = new int[n][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                b[i][j] = a[m-1-j][i]; 
            }
        }
        return b;
    }
}