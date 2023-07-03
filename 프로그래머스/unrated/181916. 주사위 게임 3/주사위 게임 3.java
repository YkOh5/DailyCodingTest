import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] points = {a, b, c, d};
        ArrayList<Integer> pointList = new ArrayList<>();
        HashMap<Integer, Integer> pointMap = new HashMap<>();        
        for (int point : points) {
            if (!pointList.contains(point)) pointList.add(point);
            pointMap.put(point, pointMap.getOrDefault(point, 0) + 1);
        }
        
        pointList.sort((num1, num2) -> pointMap.get(num2) - pointMap.get(num1));
        
        int size = pointMap.keySet().size();
        switch (size) {
            case 2 -> {
                int num1 = pointList.get(0), num2 = pointList.get(1);
                if (pointMap.get(num1) == pointMap.get(num2))
                    return (num1 + num2) * Math.abs(num1 - num2);
                else return (int)Math.pow(10 * num1 + num2, 2);
            }
            case 3 -> {return pointList.get(1) * pointList.get(2);}
            case 4 -> {
                pointList.sort((num1, num2) -> num1 - num2);
                return pointList.get(0);
            }
        }
        
        return 1111 * a;
    }
}