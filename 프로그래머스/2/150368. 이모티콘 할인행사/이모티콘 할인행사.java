import java.util.*;

class Solution {
    private final int[] discountRates = {10, 20, 30, 40};
    private int[][] users;
    private int[] emoticons;
    private int[] goalPoint = new int[]{0, 0};    

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        Stack<Integer> stack = new Stack<>();
        searchGoalPoint(stack);

        return goalPoint;
    }

    private void searchGoalPoint(Stack<Integer> stack) {
        if (stack.size() >= emoticons.length) {
            updateGoalPoint(stack);
        } else {
            for (int i = 0; i < discountRates.length; i++) {
                stack.push(discountRates[i]);
                searchGoalPoint(stack);
                if (!stack.isEmpty()) stack.pop();
            }
        }
    }

    private void updateGoalPoint(Stack<Integer> stack) {
        int[] dcrArr = new int[emoticons.length];
        int subscriberCnt = 0;
        int totalSalesRevenue = 0;

        for (int i = 0; i < emoticons.length; i++) {
            dcrArr[i] = stack.elementAt(i);
        }

        for (int i = 0; i < users.length; i++) {
            int personalSpending = 0;

            for (int j = 0; j < emoticons.length; j++) {
                if (dcrArr[j] >= users[i][0]) {
                    personalSpending += emoticons[j] * (100 - dcrArr[j]) / 100;
                }
            }

            if (personalSpending >= users[i][1]) subscriberCnt++;
            else totalSalesRevenue += personalSpending;
        }

        if (subscriberCnt > goalPoint[0] || subscriberCnt == goalPoint[0] && totalSalesRevenue > goalPoint[1]) {
            goalPoint[0] = subscriberCnt;
            goalPoint[1] = totalSalesRevenue;
        }
    }
}