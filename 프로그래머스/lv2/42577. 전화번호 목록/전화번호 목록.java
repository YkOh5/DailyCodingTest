// 정렬 후에 비교하면 한번의 반복만으로 한 번호가 다른 번호의 접두어인 경우가 있는지 알 수 있다
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}


// 3중 반복문으로 일일이 비교하는 방식은 효율성이 매우 떨어진다
// class Solution {
//     public boolean solution(String[] phone_book) {
//         for (int i = 0; i < phone_book.length; i++) {
//             for (int j = 0; j < phone_book.length; j++) {
//                 boolean isPrefix = true;
//                 // 해당 전화번호의 길이가 다른 전화번호의 길이보다 짧거나 같을 때
//                 if (i == j || phone_book[i].length() > phone_book[j].length()) continue;
//                 for (int k = 0; k < phone_book[i].length(); k++) {
//                     // 두 전화번호의 번호들을 차례대로 비교
//                     if (phone_book[i].charAt(k) != phone_book[j].charAt(k)) {
//                         isPrefix = false;
//                         break;
//                     }
//                 }
//                 if (isPrefix) return false;
//             }
//         }        
//         return true;
//     }
// }