class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 알파벳에 대한 최소한의 필요 키-입력 횟수를 원소로 갖는 배열 (A : Index 0 ~ Z : Index 25)
        int[] keyStrokes = new int[26];
        
        for (int i = 0; i < keymap.length; i++) {            
            for (int j = 0; j < keymap[i].length(); j ++) {
                // 특정 키를 눌러서 입력할 수 있는 각 알파벳에 대한 최소한의 필요 입력 횟수가
                int num = keyStrokes[keymap[i].charAt(j) - 'A'];
                // 0이거나 해당 키를 누른 횟수보다 큰 경우
                if (num == 0 || num > j + 1) {
                    // 해당 알파벳에 대한 최소한의 필요 입력 횟수를 갱신
                    keyStrokes[keymap[i].charAt(j) - 'A'] = j + 1;
                }
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                // 작성하려는 문자열의 특정 문자를 주어진 키들로 입력할 수 없는 경우
                if (keyStrokes[targets[i].charAt(j) - 'A'] == 0) {
                    sum = -1;   // 최소 필요 키-입력 횟수의 합을 -1로 갱신
                    break;   // 해당 문자열에 대한 작업 중단
                }
                // 입력할 수 있는 경우 최소 필요 키-입력 횟수를 합산
                sum += keyStrokes[targets[i].charAt(j) - 'A'];
            }
            answer[i] = sum;
        }
                
        return answer;
    }
}