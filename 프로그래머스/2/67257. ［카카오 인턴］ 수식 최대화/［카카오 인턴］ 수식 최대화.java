import java.util.ArrayList;

class Solution {
    public long solution(String expression) {
        // 연산자 우선순위에 따른 순열
        String[] opPriority = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
        ArrayList<Character> opList = new ArrayList<>();
        ArrayList<Long> numList = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        long maxReward= 0;

        // 숫자와 연산자를 각각의 리스트에 저장
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                opList.add(c);
                numList.add(Long.parseLong(num.toString()));
                num.setLength(0);
            }
        }
        // 마지막 숫자 추가
        numList.add(Long.parseLong(num.toString()));

        for (String ops : opPriority) {
            ArrayList<Long> tempNumList = new ArrayList<>(numList);
            ArrayList<Character> tempOpList = new ArrayList<>(opList);
            
            for (char op : ops.toCharArray()) {
                for (int idx = 0; idx < tempOpList.size(); idx++) {
                    // 리스트의 연산자가 우선순위에 부합하면
                    if (tempOpList.get(idx) == op) {
                        // 앞의 숫자를 연산결과로 갱신
                        tempNumList.set(idx, operate(tempNumList.get(idx), op, tempNumList.get(idx + 1)));
                        // 뒤의 숫자를 리스트에서 제거
                        tempNumList.remove(idx + 1);
                        // 해당 연산자를 리스트에서 제거
                        tempOpList.remove(idx);
                        // 인덱스 증가 무효화
                        idx--;
                    }
                }
            }
            // 최대상금 갱신
            maxReward = Math.max(maxReward, Math.abs(tempNumList.get(0)));
        }
        
        return maxReward;
    }

    private long operate(long num1, char op, long num2) {
        if (op == '+') return num1 + num2;
        else if (op == '-') return num1 - num2;
        
        return num1 * num2;
    }
}