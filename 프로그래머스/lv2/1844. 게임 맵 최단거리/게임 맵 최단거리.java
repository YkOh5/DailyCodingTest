import java.util.*;
class Solution {
    class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int N, M;
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        
        return countRoute(maps);
    }
    
    int countRoute(int[][] maps) {
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        int[][] visited = new int[N][M];
        Queue<Node> queue = new LinkedList<Node>();
        
        // 시작점 초기화
        visited[0][0] = 1;
        queue.add(new Node(0, 0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            // 현재 있는 칸에서 다음칸으로 이동했을 때 움직인 횟수
            int moveCount = visited[current.x][current.y] + 1;
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 맵 범위를 벗어났거나 벽이면 이동 불가
                if (!isIn(nx, ny) || maps[nx][ny] == 0)
                    continue;
                
                // 이미 방문한 적이 있으나 현재 움직인 값보다 더 적게 방문한 기록이 있으면 이동 불가
                if (visited[nx][ny] != 0 && visited[nx][ny] <= moveCount)
                    continue;
                
                // 방문한적이 없거나
                // 방문했지만 현재 좌표에서 이동했을때 더 빨리 도착할 수 있으면 새로 이동
                visited[nx][ny] = moveCount;
                
                // 상대팀 진영에 도착했으면 다음으로 이동 안함
                if (nx == N - 1 && ny == M - 1)
                    continue;
                
                queue.add(new Node(nx, ny));
            }
        }
        
        // 상대팀 진영으로 방문할 수 없으면 -1 리턴
        return visited[N-1][M-1] == 0 ? -1 : visited[N-1][M-1];
    }
    
    boolean isIn(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M)
            return true;
        return false;
    }
}