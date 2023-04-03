class Solution {
    public int solution(String s) {
        // 인덱스와 일치하는 숫자의 영단어들을 원소로 갖는 문자열 배열 생성
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder num = new StringBuilder();   // 숫자의 영단어
        StringBuilder arabicNum = new StringBuilder();   // 아라비아 숫자
        
        // 문자열 s의 각 문자들에 대해서
        for (int i = 0; i < s.length(); i++) {
            // 해당 문자가 숫자인 경우
            if (Character.isDigit(s.charAt(i))) {
                // 아라비아 숫자를 나타내는 StringBuilder에 추가
                arabicNum.append(s.charAt(i));
            // 해당 문자가 알파벳인 경우
            } else {
                // 숫자의 영단어를 나타내는 StringBuilder에 추가
                num.append(s.charAt(i));
            }
            
            // 영단어의 길이가 3 이상인 경우
            if (num.length() >= 3) {
                for (int j = 0; j < nums.length; j++) {
                    // 해당 단어가 영단어 배열의 원소와 일치하면
                    if (num.toString().equals(nums[j])) {
                        // 그 원소의 인덱스를 아라비아 숫자를 나타내는 StringBuilder에 추가
                        arabicNum.append(j);
                        // 숫자의 영단어를 나타내는 StringBuilder를 초기화
                        num.setLength(0);
                        break;
                    }
                }
            }
        }
        
        // 아라비아 숫자의 문자열을 정수형으로 변환해서 반환
        return Integer.parseInt(arabicNum.toString());
    }
}