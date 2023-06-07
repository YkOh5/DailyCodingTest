class Solution {
    public long solution(String numbers) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < nums.length; i++) {
            numbers = numbers.replace(nums[i], String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}



// class Solution {
//     public long solution(String numbers) {
//         return Long.parseLong(numbers.replace("one", "1")
//                               .replace("one", "1")
//                               .replace("two", "2")
//                               .replace("three", "3")
//                               .replace("four", "4")
//                               .replace("five", "5")
//                               .replace("six", "6")
//                               .replace("seven", "7")
//                               .replace("eight", "8")
//                               .replace("nine", "9")
//                               .replace("zero", "0"));
//     }
// }