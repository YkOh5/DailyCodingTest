// 놀이기구를 N번 탑승한 후 차액 : 소지금 - (놀이기구 이용료 * 이용 횟수의 총합)
// 제한사항에 따라 차액의 크기가 150억을 초과할 수 있으므로, 범위가 -21억~21억 정도인 int형으로는 감당 불가 -> long형 사용

class Solution {
    public long solution(int price, int money, int count) {
        // 놀이기구 이용 횟수의 총합
        long cntSum = count * (1 + count) / 2;
        
        // 금액이 부족하지 않으면 0을 반환, 그렇지 않으면 차액의 절대값을 반환
        return money - price * cntSum >= 0 ? 0 : Math.abs(money - price * cntSum);
        
        
        // Math.max를 이용하면 더 간결한 코드로 해결 가능
        // return Math.max(0, (long)price * (count * (1 + count) / 2) - money);
    }
}
