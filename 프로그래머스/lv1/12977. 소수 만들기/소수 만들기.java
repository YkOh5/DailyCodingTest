class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 3중 반복문으로 양의 정수 3개를 고를 수 있는 모든 경우를 구현
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // 소수 판별을 위한 메서드의 매개변수로 3개의 수를 투입
                    if (isPrimeNumber(nums[i], nums[j], nums[k])) answer++;
                }
            }
        }

        return answer;
    }
    
    // 양의 정수 3개의 합이 소수인지 판별하기 위한 메서드
    boolean isPrimeNumber(int x, int y, int z) {
        // 합의 제곱근까지만 검사함으로써 불필요한 반복 제거
        for (int i = 2; i <= Math.sqrt(x + y + z); i++) {
            if ((x + y + z) % i == 0) return false;
        }
        return true;
    }
}