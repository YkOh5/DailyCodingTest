import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        
        return day[dayOfWeekNumber - 1];
    }
}