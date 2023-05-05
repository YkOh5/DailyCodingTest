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