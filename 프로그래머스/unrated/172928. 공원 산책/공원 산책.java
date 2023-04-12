// 1. 공원(park)에서 출발점 탐색
// 2. 경로(routes)들 각각에 대해 공원을 벗어나거나 장애물에 가로막히는 경우가 있는지 확인
// 3. 해당 경로가 유효하다면 현재 위치를 갱신

class Solution {
    private int[] curPos = new int[2];   // 현재 위치
    
    public int[] solution(String[] park, String[] routes) {
        findStartingPoint(park);   // 출발점 찾기
        
        for (int i = 0; i < routes.length; i++) {
            char op = routes[i].charAt(0);   // 이동 방향
            int n = Character.getNumericValue(routes[i].charAt(2));   // 이동할 칸의 수
            
            // 이동 명령 수행
            switch (op) {
                case 'E' : moveEast(park, n);   // 동
                    break;
                case 'W' : moveWest(park, n);   // 서
                    break;
                case 'S' : moveSouth(park, n);  // 남
                    break;
                case 'N' : moveNorth(park, n);  // 북
            }
        }
                
        return curPos;
    }
    
    // 출발점 찾기
    private void findStartingPoint(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    curPos[0] = i;   // 세로 좌표
                    curPos[1] = j;   // 가로 좌표
                    return;
                }
            }
        }
    }
    
    // 동쪽으로 이동
    private void moveEast(String[] park, int n) {
        if (curPos[1] + n >= park[0].length()) return;   // 공원을 벗어난 경우
        for (int j = 1; j <= n; j++) {
            if (park[curPos[0]].charAt(curPos[1] + j) == 'X') return;   // 장애물에 가로막힌 경우
        }                
        curPos[1] = curPos[1] + n;   // 현재 위치 갱신
    }
    
    // 서쪽으로 이동
    private void moveWest(String[] park, int n) {
        if (curPos[1] - n < 0) return;
        for (int j = 1; j <= n; j++) {
            if (park[curPos[0]].charAt(curPos[1] - j) == 'X') return;
        }                
        curPos[1] = curPos[1] - n;
    }
    
    // 남쪽으로 이동
    private void moveSouth(String[] park, int n) {
        if (curPos[0] + n >= park.length) return;
        for (int j = 1; j <= n; j++) {
            if (park[curPos[0] + j].charAt(curPos[1]) == 'X') return;
        }                
        curPos[0] = curPos[0] + n;
    }
    
    // 북쪽으로 이동
    private void moveNorth(String[] park, int n) {
        if (curPos[0] - n < 0) return;
        for (int j = 1; j <= n; j++) {
            if (park[curPos[0] - j].charAt(curPos[1]) == 'X') return;
        }                
        curPos[0] = curPos[0] - n;
    }
}
