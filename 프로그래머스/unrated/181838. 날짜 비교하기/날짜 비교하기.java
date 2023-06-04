class Solution {
    public int solution(int[] date1, int[] date2) {
        return getDateAsInt(date1) < getDateAsInt(date2)? 1 : 0;
    }
    
    private int getDateAsInt (int[] date) {
        StringBuilder sb = new StringBuilder(date[0]);
        for (int num : date) {
            if (num < 10) sb.append(0);
            sb.append(num);
        }
        
        return Integer.parseInt(sb.toString());
    }
}



// class Solution {
//     public int solution(int[] date1, int[] date2) {
//         String strD1 = String.format("%d%02d%02d", date1[0], date1[1], date1[2]);
//         String strD2 = String.format("%d%02d%02d", date2[0], date2[1], date2[2]);
                
//         return Integer.parseInt(strD1) < Integer.parseInt(strD2)? 1 : 0;
//     }
// }



// import java.time.LocalDate;

// class Solution {
//     public int solution(int[] date1, int[] date2) {
//         return LocalDate.of(date1[0], date1[1], date1[2])
//                 .isBefore(LocalDate.of(date2[0], date2[1], date2[2])) ? 1 : 0;
//     }
// }