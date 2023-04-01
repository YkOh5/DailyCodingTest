import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};   // 요일
        
        LocalDate date = LocalDate.of(2016, a, b);   // 연, 월, 일
        DayOfWeek dayOfWeek = date.getDayOfWeek();   // 해당 일자의 요일 (Enum)
        int dayOfWeekNumber = dayOfWeek.getValue();  // 요일의 값 (월요일:1 ~ 일요일:7)
        
        return day[dayOfWeekNumber - 1];
        
        
        // 단 한 줄의 코드로 해결 가능
        // return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
        
        
        // time 클래스를 사용하지 않고 직접 구현하는 방식이 처리속도면에서는 월등하다
        // String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        // int[] dateM = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};        
        // int dateY = b - 1;        
        // if (a >= 2) {
        //     for (int i = 0; i < a - 1; i++) {
        //     dateY += dateM[i];
        //     }
        // }        
        // return day[dateY % 7];
    }
}
