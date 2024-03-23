class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            char[][] wRoom = new char[places[0].length][places[0][0].length()];
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    wRoom[j][k] = places[i][j].charAt(k);
                }
            }
            
            answer[i] = checkDistancing(wRoom);
        }        
        
        return answer;
    }
    
    private int checkDistancing(char[][] wRoom) {
        for (int i = 0; i < wRoom.length; i++) {
            for (int j = 0; j < wRoom[i].length; j++) {
                if (wRoom[i][j] == 'P' && checkSurround(wRoom, i, j) == false) return 0;
            }
        }
        
        return 1;
    }
    
    private boolean checkSurround(char[][] wRoom, int x, int y) {
        if (x + 1 < wRoom.length && wRoom[x + 1][y] == 'P') return false;
        if (y + 1 < wRoom[x].length && wRoom[x][y + 1] == 'P') return false;
        if (x + 1 < wRoom.length && y + 1 < wRoom[x].length && wRoom[x + 1][y + 1] == 'P' && (wRoom[x + 1][y] == 'O' || wRoom[x][y + 1] == 'O')) return false;
        if (x + 1 < wRoom.length && y - 1 < wRoom[x].length && y - 1 >= 0 && wRoom[x + 1][y - 1] == 'P' && (wRoom[x + 1][y] == 'O' || wRoom[x][y - 1] == 'O')) return false;
        if (x + 2 < wRoom.length && wRoom[x + 2][y] == 'P' && wRoom[x + 1][y] == 'O') return false;
        if (y + 2 < wRoom[x].length && wRoom[x][y + 2] == 'P' && wRoom[x][y + 1] == 'O') return false;
        
        return true;
    }
}