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

// Change 로그를 제외한 Enter와 Leave 로그만 추출한 자료를 활용하고
// String.split() 대신 StringTokenizer.nextToken()을 사용하면 처리속도를 높일 수 있다

// class Solution {
//     private HashMap<String, String> nicknameMap = new HashMap<>();
//     private ArrayList<String[]> tempAccessLogs = new ArrayList<>();
//     private ArrayList<String> userAccessLogs = new ArrayList<>();
    
//     public String[] solution(String[] record) {
//         processRawData(record);
//         updateAccessLogs(record);
        
//         return userAccessLogs.toArray(new String[0]);
//     }
    
//     private void processRawData(String[] record) {
//         for (int i = 0; i < record.length; i++) {
//             StringTokenizer st = new StringTokenizer(record[i], " ");
//             String cmd = st.nextToken();
//             String uid = st.nextToken();
            
//             if (cmd.equals("Enter")) {
//                 tempAccessLogs.add(new String[]{uid, "님이 들어왔습니다."});
//                 nicknameMap.put(uid, st.nextToken());
//             } else if (cmd.equals("Leave")) {
//                 tempAccessLogs.add(new String[]{uid, "님이 나갔습니다."});
//             } else if (cmd.equals("Change")) {
//                 nicknameMap.put(uid, st.nextToken());
//             }
//         }
//     }
    
//     private void updateAccessLogs(String[] record) {
//         for (int i = 0; i < tempAccessLogs.size(); i++) {
//             userAccessLogs.add(nicknameMap.get(tempAccessLogs.get(i)[0]) + tempAccessLogs.get(i)[1]);
//         }
//     }    
// }