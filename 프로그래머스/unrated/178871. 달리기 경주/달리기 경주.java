import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 시간복잡도를 줄이기 위해서 HashMap을 이용
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        int targetIdx = 0;
        for (String name : callings) {
            targetIdx = map.get(name);   // 호명된 선수의 등수 - 1
            String tmp = players[targetIdx - 1];   // 추월당한 선수의 이름
            // 배열 갱신
            players[targetIdx - 1] = players[targetIdx];
            players[targetIdx] = tmp;
            // HashMap 갱신
            map.put(name, targetIdx - 1);
            map.put(tmp, map.get(tmp) + 1);
        }
        
        return players;
    }
}