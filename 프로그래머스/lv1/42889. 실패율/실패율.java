import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int players = stages.length;   // 총 사용자 수
        int[] challengers = new int[N + 1];   // 각 스테이지에 도전 중인 사용자 수
        double[] failureRate = new double[N]; // 각 스테이지의 실패율
        double[][] stageFailureRate = new double[N][2];   // 스테이지와 실패율을 매핑
        // StageFailureRate[] stageFailureRate = new StageFailureRate[N];

        for (int i = 0; i < stages.length; i++) {
            challengers[stages[i] - 1]++;
        }

        for (int i = 0; i < N; i++) {
            if (players == 0)   // 스테이지에 도달한 사용자가 없는 경우
                failureRate[i] = 0;   // 해당 스테이지의 실패율 = 0%
            else   // 실패율 = 현재 스테이지에 도전 중인 사용자 수 / 도달한 총 사용자 수
                failureRate[i] = (double)challengers[i] / players;
            players -= challengers[i];   // 다음 스테이지에 도달한 총 사용자 수
            // 각각의 스테이지와 실패율을 매핑
            stageFailureRate[i][0] = i + 1;
            stageFailureRate[i][1] = failureRate[i];
            // stageFailureRate[i] = new StageFailureRate(i + 1, failureRate[i]);
        }

        // 실패율을 기준으로 내림차순으로 정렬
        Arrays.sort(stageFailureRate, (r1, r2) -> Double.compare(r2[1], r1[1]));
        // Arrays.sort(stageFailureRate, (r1, r2) -> Double.compare(r2.failureRate, r1.failureRate));

        // 정렬된 스테이지의 번호들을 추출
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int)stageFailureRate[i][0];
            // answer[i] = stageFailureRate[i].stage;
        }

        return answer;
    }
}

// 별도의 클래스를 만들어서 다루는 방식이 좀 더 객체지향적인 것 같긴 하지만, 이렇게 하는게 맞나??
// class StageFailureRate {
//     int stage;
//     double failureRate;
    
//     StageFailureRate(int stage, double failureRate) {
//         this.stage = stage;
//         this.failureRate = failureRate;
//     }
// }