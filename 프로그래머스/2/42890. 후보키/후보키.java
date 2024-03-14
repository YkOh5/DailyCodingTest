import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> subsetList = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int[] arr = new int[relation[0].length];        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for (int limit = 1; limit <= arr.length; limit++) {
            getSubsets(arr, new ArrayList<>(), 0, limit);
        }
        
        ArrayList<ArrayList<Integer>> cKeyList = new ArrayList<>();
        for (ArrayList<Integer> subset : subsetList) {
            // 최소성 검증
            boolean minimal = true;
            for (ArrayList<Integer> cKey : cKeyList) {
                if (subset.containsAll(cKey)) {
                    minimal = false;
                    break;
                }
            }
            
            if (!minimal) continue;
            
            // 유일성 검증
            HashSet<ArrayList<String>> subsetSet = new HashSet<>();            
            for (int i = 0; i < relation.length; i++) {
                ArrayList<String> list = new ArrayList<>();
                for (int num : subset) {
                    list.add(relation[i][num]);
                }
                
                if (subsetSet.contains(list)) break;
                else subsetSet.add(list);
            }
            
            if (subsetSet.size() == relation.length) cKeyList.add(subset);
        }
                
        return cKeyList.size();
    }
    
    private void getSubsets(int[] arr, ArrayList<Integer> subset, int idx, int limit) {
        if (subset.size() == limit) {
            subsetList.add(new ArrayList<>(subset));
            
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            subset.add(arr[i]);
            getSubsets(arr, subset, i + 1, limit);
            subset.remove(subset.size() - 1);
        }
    }
}