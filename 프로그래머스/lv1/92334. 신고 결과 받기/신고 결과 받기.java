import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = getReportMap(id_list, report);
        HashMap<String, Integer> reportedCountMap = getReportedCountMap(reportMap);
        int[] bannedIdCountByReporter = new int[id_list.length];
        
        // 모든 사용자 아이디에 대해서
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reportedIdSet = reportMap.get(id_list[i]);
            // 해당 사용자로부터 신고 당한 아이디의
            for (String reportedId : reportedIdSet) {
                // 피신고 횟수가 정지 기준을 넘은 경우
                if (reportedCountMap.getOrDefault(reportedId, 0) >= k)
                    bannedIdCountByReporter[i]++;   // 사용자가 처리 결과 메일을 받은 횟수 증가
            }
        }            
                
        return bannedIdCountByReporter;
    }
    
    // 신고자와 피신고자를 매핑
    private HashMap<String, HashSet<String>> getReportMap(String[] id_list, String[] report) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        for (String id : id_list) {
          reportMap.put(id, new HashSet<String>());
        }
        for (String reportEntry : report) {
            String[] entry = reportEntry.split(" ");
            HashSet<String> reportedIdSet = reportMap.get(entry[0]);
            reportedIdSet.add(entry[1]);
        }
        
        return reportMap;
    }
    
    // 피신고자와 피신고 횟수를 매핑
    private HashMap<String, Integer> getReportedCountMap(HashMap<String, HashSet<String>> reportMap) {
        Set<String> reporterIdSet = reportMap.keySet();
        HashMap<String, Integer> reportedCountMap = new HashMap<>();
        for (String reporterId : reporterIdSet) {
            HashSet<String> reportedIdSetByReporter = reportMap.get(reporterId);
            for (String reportedId : reportedIdSetByReporter) {
                reportedCountMap.put(reportedId, reportedCountMap.getOrDefault(reportedId, 0) + 1);
            }
        }
        
        return reportedCountMap;
    }
}