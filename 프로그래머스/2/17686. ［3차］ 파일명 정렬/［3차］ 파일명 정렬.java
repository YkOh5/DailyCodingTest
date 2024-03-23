import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        ArrayList<String> fileList = new ArrayList<>();
        fileList.add(files[0]);
        
        for (int i = 1; i < files.length; i++) {
            String[] headNum1 = getHeadAndNumber(files[i]);
            boolean inserted = false;
            
            targetLoop:
            for (int j = 0; j < fileList.size(); j++) {
                String[] headNum2 = getHeadAndNumber(fileList.get(j));
                
                if (headNum1[0].equals(headNum2[0])) {
                    if (Integer.parseInt(headNum1[1]) >= Integer.parseInt(headNum2[1])) continue;
                    else {                        
                        fileList.add(j, files[i]);
                        inserted = true;
                        break;
                         }
                } else {
                    for (int k = 0; k < headNum1[0].length(); k++) {
                        if (k >= headNum2[0].length()) break;                        
                        if (headNum1[0].charAt(k) > headNum2[0].charAt(k)) break;
                        if (headNum1[0].charAt(k) < headNum2[0].charAt(k)) {
                            fileList.add(j, files[i]);
                            inserted = true;
                            break targetLoop;
                        }
                        if (k == headNum1[0].length() - 1 && headNum1[0].length() < headNum2[0].length()) {
                            fileList.add(j, files[i]);
                            inserted = true;
                            break targetLoop;
                        }
                    }
                }
            }            
            
            if (!inserted) fileList.add(files[i]);
        }
        
        return fileList.toArray(new String[0]);
    }
    
    private String[] getHeadAndNumber(String file) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        boolean isHead = true;
        
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) isHead = false;
            
            if (isHead) head.append(file.charAt(i));
            else if (!isHead && !Character.isDigit(file.charAt(i))) break;
            else number.append(file.charAt(i));
        }
        
        return new String[]{head.toString().toUpperCase(), String.valueOf(Integer.parseInt(number.toString()))};
    }
}