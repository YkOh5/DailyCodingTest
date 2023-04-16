class Solution {
    public String solution(String new_id) {                
        return toRecommendedKakaoId(new_id);
    }
    
    private String toRecommendedKakaoId(String id) {
        id = id.toLowerCase()   // 1단계
                .replaceAll("[^a-z0-9-_.]", "")   // 2단계
                .replaceAll("\\.{2,}", ".")   // 3단계
                .replaceAll("^\\.|\\.$", "");   // 4단계
        
        StringBuilder sb = new StringBuilder(id);
        if (sb.length() == 0) sb.append("a");   // 5단계
        if (sb.length() >= 16) sb.delete(15, sb.length());   // 6단계
        if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        while (sb.length() < 3) sb.append(sb.charAt(sb.length() - 1));   // 7단계
        
        return sb.toString();
    }
}


// 다음은 처리속도가 느리고, java 답지 않은 코드이다
// class Solution {
//     public String solution(String new_id) {
//         new_id = new_id.toLowerCase()
//                         .replaceAll("[^a-z0-9-_.]", "")
//                         .replaceAll("\\.{2,}", ".")
//                         .replaceAll("^\\.|\\.$", "");        
//         if (new_id.length() == 0) new_id = "a";
//         if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
//         if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);
//         while (new_id.length() < 3) new_id += new_id.charAt(new_id.length() - 1);        
//         return new_id;
//     }
// }
