// DB 내 주어진 열(column)들의 멱집합에서 공집합을 제외한 모든 부분집합들 중 유일성과 최소성을 만족하는 경우 후보키로 쓰일 수 있다.

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
            for (int row = 0; row < relation.length; row++) {
                ArrayList<String> list = new ArrayList<>();
                for (int col : subset) {
                    list.add(relation[row][col]);
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