// 1. 지도 상 분기점이 적다면 DFS를 활용하는게 효율적일 수 있지만, 분기점이 많다면 매우 비효율적이므로 BFS를 이용
// 2. 일반적으로 BFS를 구현하기 위해서 Queue와 visited자료를 활용
// 3. 아군 진영(값=1)에서부터 아군이 새롭게 이동한 칸의 값은 이전에 위치했던 칸의 값 +1로 설정
// 4. 아군이 상대 진영에 도달할 수 있다면 상대 진영의 값은 우리팀이 지나간 칸 수의 총합
// ex) [[1, 0, 9,10, 11],
//      [2, 0, 8, 0, 10],
//      [3, 0, 7, 8, 9],
//      [4, 5, 6, 0, 10],
//      [0, 0, 0, 0, 11]]

import java.util.*;

class Pos {
    int x;
    int y;
    
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 맵에서 아군팀이 지나간 칸은 기존 값 1에서 우리팀이 지나간 칸 수의 총합으로 변하므로 
        // 일반적인 BFS처럼 굳이 visited배열을 쓸 필요가 없다
        // int[][] visited = new int[n][m];
        
        // 동, 서, 남, 북으로의 변위
        int[] dX = {1, -1, 0, 0};
        int[] dY = {0, 0, 1, -1};
        
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        
        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            
            // 동, 서, 남, 북으로 이동 시의 위치에 대해서
            for (int i = 0; i < 4; i++) {
                int nextX = curPos.x + dX[i];
                int nextY = curPos.y + dY[i];
                
                // 이동할 위치가 맵의 안쪽이고, 지나갈 수 있는 곳(위치의 값 = 1)일 경우
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && maps[nextX][nextY] == 1) {
                    maps[nextX][nextY] = maps[curPos.x][curPos.y] + 1;   // 다음 위치의 값 = 현재 위치의 값 + 1
                    queue.add(new Pos(nextX, nextY));
                }
            }
        }
        
        // 상대팀 진영에 도달할 수 있다면 기존 값 1이 우리팀이 지나간 칸 수의 총합으로 변하므로
        return maps[n-1][m-1] == 1? -1: maps[n-1][m-1];
    }
}