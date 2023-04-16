class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase()   // 1단계
                        .replaceAll("[^a-z0-9-_.]", "")   // 2단계
                        .replaceAll("\\.{2,}", ".")   // 3단계
                        .replaceAll("^\\.|\\.$", "");   // 4단계
        
        StringBuilder sb = new StringBuilder(new_id);
        if (sb.length() == 0) sb.append("a");   // 5단계
        if (sb.length() >= 16) sb.delete(15, sb.length());   // 6단계
        if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        while (sb.length() < 3) sb.append(sb.charAt(sb.length() - 1));   // 7단계
        
        return sb.toString();
    }
}