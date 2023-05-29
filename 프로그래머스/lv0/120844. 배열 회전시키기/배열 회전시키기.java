class Solution {
    private int[] rotatedNums;
    
    public int[] solution(int[] numbers, String direction) {        
        rotatedNums = new int[numbers.length];
        return (direction.equals("left"))? rotateLeft(numbers) : rotateRight(numbers);
    }
    
    private int[] rotateLeft(int[] numbers) {
        rotatedNums[rotatedNums.length - 1] = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            rotatedNums[i] = numbers[i + 1];
        }
        
        return rotatedNums;
    }
    
    private int[] rotateRight(int[] numbers) {
        rotatedNums[0] = numbers[numbers.length - 1];
        for (int i = 1; i < numbers.length; i++) {
            rotatedNums[i] = numbers[i - 1];
        }        
        
        return rotatedNums;
    }
}