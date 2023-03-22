import java.util.Scanner;
// import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();   // 가로 길이
        int b = sc.nextInt();   // 세로 길이
        
        // 세로
        for (int i = 1; i <= b; i++) {
            // 가로
            for (int j = 1; j <= a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        
        // Stream을 활용한 풀이
        // StringBuilder sb = new StringBuilder();
        // IntStream.range(0, a).forEach(s -> sb.append("*"));   // 가로
        // IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));   //세로
    }
}
