import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];

        int max = 1;


        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    //System.out.println("arr[" + i + "]: " + arr[i]);
                    //System.out.println("arr[" + j + "]: " + arr[j]);
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 첫 수부터 현재값까지 점증 가능한 경우 dp 값 갱신
                    // 즉 현재 값을 선택하는 수열의 마지막 값이라고 했을 때 최장 길이를 보는 것
                    //System.out.println("현재 dp[" + i + "]: " + dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
            //System.out.println("최종 dp[" + i + "]: " + dp[i]);
            //System.out.println("max: " + max);
            //System.out.println("========================================");
        }
        System.out.println(max);


    }
}