import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] circularElements = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            circularElements[i + elements.length] = circularElements[i] = elements[i];
        }
        
        HashSet<Integer> sumSet = new HashSet<>();        
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += circularElements[j + k];
                }
                sumSet.add(sum);
            }
        }   
        
        return sumSet.size();
    }
}