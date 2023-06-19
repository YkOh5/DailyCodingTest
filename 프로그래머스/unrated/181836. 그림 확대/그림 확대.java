import java.util.ArrayList;

class Solution {
    private StringBuilder sb = new StringBuilder();
    private ArrayList<String> strList = new ArrayList<>();
    
    public String[] solution(String[] picture, int k) {
        for (String horizontalPixels : picture) {
            for (int i = 0; i < k; i++) {
                resizeHorizontalPixels(horizontalPixels, k);
            }
        }
        
        return strList.toArray(new String[0]);
    }
    
    private void resizeHorizontalPixels(String horizontalPixels, int k) {
        for (char pixel : horizontalPixels.toCharArray()) {
            for (int i = 0; i < k; i++) {
                sb.append(pixel);
            }
            
        }
        strList.add(sb.toString());
        sb.setLength(0);
    }
}