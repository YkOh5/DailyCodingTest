import java.util.*;

class Solution {
    public Integer[] solution(int[] fees, String[] records) {        
        HashMap<Integer, int[]> map = new HashMap<>();
        
        for (int i = records.length - 1; i >= 0; i--) {
            String[] record = records[i].split("\\s+");
            int vehicleNumber = Integer.parseInt(record[1]);
            int hour = Integer.parseInt(record[0].substring(0, 2));
            int minute = Integer.parseInt(record[0].substring(3));
            
            int[] upcomingRecord = map.getOrDefault(vehicleNumber, new int[]{23, 59, 0});
            
            if (record[2].equals("OUT")) {                
                map.put(vehicleNumber, new int[]{hour, minute, upcomingRecord[2]});
            } else {
                int duration = (upcomingRecord[0] - hour) * 60 + (upcomingRecord[1] - minute);
                map.put(vehicleNumber, new int[]{hour, minute, upcomingRecord[2] + duration});
            }
        }
        
        List<Integer> parkingFees = new ArrayList<>();
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            int totalParkingDuration = map.get(key)[2];
            
            if (totalParkingDuration < fees[0]) {
                parkingFees.add(fees[1]);
            } else {
                int parkingFee = fees[1] + (int) Math.ceil((double)(totalParkingDuration - fees[0]) / fees[2]) * fees[3];
                parkingFees.add(parkingFee);
            }            
        }
        
        return parkingFees.toArray(new Integer[0]);
    }
}