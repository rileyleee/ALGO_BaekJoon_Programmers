import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1]; // 계단 1개일 때 최대 값은 1번 계단 값

        if (n > 1) {
            dp[2] = arr[1] + arr[2]; // 계단 2개일 때 밟을 수 있는 최대 값은 1번 2번 계단 다 밟는 것
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
            // 3개 이상 밟을 수 없기 때문에 직전 것을 밟은 경우 여부에 따라 최대값 찾기
            // 3개 전까지의 최대값 + 직전 값 + 현재 값 VS 2개 전까지의 최대값 + 현재값
        }

        System.out.println(dp[n]);

    }
}