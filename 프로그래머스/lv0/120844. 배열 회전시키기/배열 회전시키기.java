class Solution {
    public int[] solution(int[] numbers, String direction) {        
        return (direction.equals("left"))? rotateLeft(numbers) : rotateRight(numbers);
    }
    
    private int[] rotateLeft(int[] numbers) {
        int tmp = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i - 1] = numbers[i];
        }
        numbers[numbers.length - 1] = tmp;
        
        return numbers;
    }
    
    private int[] rotateRight(int[] numbers) {
        int tmp = numbers[numbers.length - 1];
        for (int i = numbers.length - 2; i >= 0; i--) {
            numbers[i + 1] = numbers[i];
        }
        numbers[0] = tmp;
        
        return numbers;
    }
}