import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        
        return day[dayOfWeekNumber - 1];
        
        
        // 단 한 줄의 코드로 해결 가능
        // return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
    }
}
