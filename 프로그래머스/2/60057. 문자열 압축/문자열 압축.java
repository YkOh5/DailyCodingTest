class Solution {
    public int solution(String s) {
        if (s.length() == 1) return 1;
        
        int minCompSize = Integer.MAX_VALUE;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            int strCnt = 1;
            StringBuilder sb = new StringBuilder();
            String temp = s.substring(0, i);
            
            for (int j = i; j < s.length(); j++) {
                if (s.substring(j).startsWith(temp)) {
                    strCnt++;                    
                } else {
                    if (strCnt != 1) {
                        sb.append(strCnt);
                        strCnt = 1;
                    }
                    sb.append(temp);
                    
                    if (j + i <= s.length()) temp = s.substring(j, j + i);
                    else temp = s.substring(j);
                }
                
                j += i - 1;
            }
            
            if (strCnt != 1) sb.append(strCnt);
            sb.append(temp);
            
            minCompSize = Math.min(minCompSize, sb.length());
        }
                
        return minCompSize;
    }
}