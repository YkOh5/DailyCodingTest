import java.util.Scanner;

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
    }
}