import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dateM = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int dateY = b - 1;
        
        if (a >= 2) {
            for (int i = 0; i < a - 1; i++) {
            dateY += dateM[i];
            }
        }
        
        return day[dateY % 7];
        
        
        
//         String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        
//         LocalDate date = LocalDate.of(2016, a, b);
//         DayOfWeek dayOfWeek = date.getDayOfWeek();
//         int dayOfWeekNumber = dayOfWeek.getValue();
        
//         return day[dayOfWeekNumber - 1];
        
        
        // 단 한 줄의 코드로 해결 가능
        // return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);        
    }
}