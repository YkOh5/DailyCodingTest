import java.util.ArrayList;

class Solution {
    private ArrayList<Integer> numList = new ArrayList<>();
    private int startIdx = 0;
    private int endIdx = 0;
    private int interval = 1;
    
    public Integer[] solution(int n, int[] slicer, int[] num_list) {
        selectIndices(n, slicer, num_list);
        for (int i = startIdx; i <= endIdx; i += interval) {
            numList.add(num_list[i]);
        }
        
        return numList.toArray(new Integer[0]);
    }
    
    private void selectIndices(int n, int[] slicer, int[] num_list) {
        switch (n) {
            case 1 -> {
                startIdx = 0;
                endIdx = slicer[1];
            }
            case 2 -> {
                startIdx = slicer[0];
                endIdx = num_list.length - 1;
            }
            case 3 -> {
                startIdx = slicer[0];
                endIdx = slicer[1];
            }
            case 4 -> {
                startIdx = slicer[0];
                endIdx = slicer[1];
                interval = slicer[2];
            }
        }
    }
}