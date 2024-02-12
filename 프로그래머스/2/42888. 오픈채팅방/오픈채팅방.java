import java.util.*;

class Solution {    
    private HashMap<String, String> uidNickMap = new HashMap<>();
    private ArrayList<String> userAccessLogs = new ArrayList<>();
    
    public String[] solution(String[] record) {
        setNickName(record);
        updateAccessLogs(record);
        
        return userAccessLogs.toArray(new String[0]);
    }
    
    private void setNickName(String[] record) {
        for (int i = 0; i < record.length; i++) {
            String[] partialRecord = record[i].split("\\s+");
            
            if (partialRecord[0].equals("Enter") || partialRecord[0].equals("Change")) {
                uidNickMap.put(partialRecord[1], partialRecord[2]);
            }
        }
    }
    
    private void updateAccessLogs(String[] record) {
        for (int i = 0; i < record.length; i++) {
            String[] partialRecord = record[i].split("\\s+");
            
            if (partialRecord[0].equals("Enter")) {
                userAccessLogs.add(uidNickMap.get(partialRecord[1]) + "님이 들어왔습니다.");
            } else if (partialRecord[0].equals("Leave")) {
                userAccessLogs.add(uidNickMap.get(partialRecord[1]) + "님이 나갔습니다.");
            }
        }
    }
}