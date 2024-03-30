import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        ArrayList<Integer> timeList = new ArrayList<>();
        for (String time : timetable) {
            StringTokenizer st = new StringTokenizer(time, ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            timeList.add(hour * 60 + minute);
        }
        
        Collections.sort(timeList);
                
        int lastArvTime = 0;
        boolean isLastShuttleFull = false;
        for (int i = 0; i < n; i++) {
            int shtTime = 540 + i * t;
            int psgCnt = 0;
            
            while (timeList.size() > 0 && timeList.get(0) <= shtTime && psgCnt < m) {
                lastArvTime = timeList.remove(0);
                psgCnt++;
            }
            
            if (i == n - 1 && psgCnt == m) isLastShuttleFull = true;
        }
        
        int lastShtTime = (540 + (n - 1) * t >= 1440)? 1439 : 540 + (n - 1) * t;
        int conArvTime = (isLastShuttleFull)? lastArvTime - 1 : lastShtTime;
                
        return String.format("%02d:%02d", conArvTime / 60, conArvTime % 60);
    }
}