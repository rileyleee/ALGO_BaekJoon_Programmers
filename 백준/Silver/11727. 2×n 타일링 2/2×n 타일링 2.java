import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 3]; // 3 인덱스까지는 초기값 설정해야 해서

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        if (n <= 3) {
            System.out.println(dp[n]);
        } else {
            //System.out.println("여기 들어왔나요");

            for (int i = 4; i <= n; i++) {

                int tmp = (3* dp[i - 2]) + (2 * dp[i - 3]);

                dp[i] = tmp % 10007;
            }

            System.out.println(dp[n]);
        }
    }
}