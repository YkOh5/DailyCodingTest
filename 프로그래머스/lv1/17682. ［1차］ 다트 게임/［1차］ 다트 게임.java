class Solution {
    public int solution(String dartResult) {
        // 전체 코드를 단순화하기 위해서 10을 t로 대체
        dartResult = dartResult.replace("10", "t");
        int prevPt = 0;   // 이전 점수
        int curPt = 0;   // 현재 점수
        int sum = 0;   // 점수 합계
        
        for (char target : dartResult.toCharArray()) {            
            switch (target) {
                case 'S' -> curPt = curPt;
                case 'D' -> curPt = (int)Math.pow(curPt, 2);
                case 'T' -> curPt = (int)Math.pow(curPt, 3);
                case '*' -> { curPt *= 2;
                        sum += prevPt; }
                case '#' -> curPt *= -1;
                case 't' -> { prevPt = curPt;
                        sum += prevPt;
                        curPt = 10; }
                default -> { prevPt = curPt;
                        sum += prevPt;
                        curPt = Character.getNumericValue(target); }
            }
        }
        
        sum += curPt;
        
        return sum;
    }
}