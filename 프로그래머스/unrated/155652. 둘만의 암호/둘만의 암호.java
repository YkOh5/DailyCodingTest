// 1. skip에 포함된 알파벳들을 HashSet에 추가
// 2. 변경될 문자열을 배열에 추가
// 3. 반복문으로 배열에 추가된 문자들을 index만큼 증가 (단, 해당 문자가 z인 경우는 a로 초기화)
// 4. 변경된 문자가 HashSet에 포함되어 있지 않을 때까지 계속 증가 

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        HashSet<Character> set = new HashSet<>();    

        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }

        char[] charArr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            charArr[i] = s.charAt(i);
        }

        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < index; j++) {
                while (true) {
                    if (charArr[i] == 'z') {
                        charArr[i] = 'a';
                    } else {
                        charArr[i]++;
                    }

                    if (!set.contains(charArr[i])) {
                        break;
                    }
                }              
            }
        }

        String answer = "";

        for (char item: charArr) {
            answer += item;
        }                                                     

        return answer;
    }
}