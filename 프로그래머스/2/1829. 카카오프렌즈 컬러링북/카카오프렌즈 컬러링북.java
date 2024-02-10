import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private boolean[][] visited;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int numberOfArea = 0;
        int sizeOfMaxArea = 0;
        
        for(int x = 0; x < picture.length; x++) {
            for (int y = 0; y < picture[x].length; y++) {
                if (visited[x][y] == false && picture[x][y] != 0) {
                    numberOfArea++;
                    sizeOfMaxArea = Math.max(sizeOfMaxArea, findSizeOfArea(x, y, picture));
                }                
            }
        }
        
        return new int[]{numberOfArea, sizeOfMaxArea};
    }
    
    private int findSizeOfArea(int x, int y, int[][] picture) {
        int sizeOfArea = 1;
        visited[x][y] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];
                
                if (0 <= nx && nx < picture.length && 0 <= ny && ny < picture[nx].length 
                   && visited[nx][ny] == false && picture[nx][ny] == picture[x][y]) {
                    sizeOfArea++;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return sizeOfArea;
    }
}