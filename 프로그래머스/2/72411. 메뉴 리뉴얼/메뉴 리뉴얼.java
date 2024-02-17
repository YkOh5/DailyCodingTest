import java.util.*;

class Solution {
    private HashMap<String, Integer> commonMenuMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        getCommonMenuMap(orders, course);
        
        return getCourseMenuOptions();
    }
    
    private void getCommonMenuMap(String[] orders, int[] course) {
        HashSet<Integer> dishCntSet = new HashSet<>();
        for (int dishCnt : course) dishCntSet.add(dishCnt); 
        
        for (String order : orders) {
            if (order.length() >= course[0]) {
                StringBuilder orderSubset = new StringBuilder();
                char[] orderCharArr = order.toCharArray();
                Arrays.sort(orderCharArr);
                getValidOrderSubsets(new String(orderCharArr), dishCntSet, orderSubset, 0);
            }
        }
    }
    
    private void getValidOrderSubsets(String sortedOrder, HashSet<Integer> dishCntSet, StringBuilder orderSubset, int index) {
        if (dishCntSet.contains(orderSubset.length())) {
            commonMenuMap.put(orderSubset.toString(), commonMenuMap.getOrDefault(orderSubset.toString(), 0) + 1);
        }
        
        for (int i = index; i < sortedOrder.length(); i++) {
            orderSubset.append(sortedOrder.charAt(i));
            getValidOrderSubsets(sortedOrder, dishCntSet, orderSubset, i + 1);
            orderSubset.deleteCharAt(orderSubset.length() - 1);
        }
    }
    
    private String[] getCourseMenuOptions() {
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, Integer> orderCntMap = new HashMap<>();
        
        for (String key : commonMenuMap.keySet()) {            
            if (commonMenuMap.get(key) > orderCntMap.getOrDefault(key.length(), 0)) {
                orderCntMap.put(key.length(), commonMenuMap.get(key));
            }
        }
        
        for (String key : commonMenuMap.keySet()) {
            if (commonMenuMap.get(key) >= 2 && commonMenuMap.get(key) == orderCntMap.get(key.length())) {
                list.add(key);
            }
        }
        
        Collections.sort(list);
        
        return list.toArray(new String[0]);
    }
}