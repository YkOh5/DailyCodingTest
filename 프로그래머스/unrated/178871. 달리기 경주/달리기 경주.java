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


// 아래와 같이 이중반복문으로 배열의 원소끼리 낱낱이 비교하는 단순한 방식은 비효율적이다
// class Solution {
//     public String[] solution(String[] players, String[] callings) {
//         for (int i = 0; i < callings.length; i++) {
//             for (int j = 0 ; j < players.length; j++) {
//                 if (callings[i].equals(players[j])) {
//                     String tmp = players[j - 1];
//                     players[j - 1] = players[j];
//                     players[j] = tmp;
//                 }
//             }
//         }                
//         return players;
//     }
// }
