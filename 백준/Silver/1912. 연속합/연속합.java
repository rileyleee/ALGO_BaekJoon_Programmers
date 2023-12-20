import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[num];

        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < num; i++) {

            //System.out.println("dp[" + (i - 1) + "]+arr[" + i + "]: " + (dp[i - 1] + arr[i]));
            //System.out.println("arr[" + i + "]: " + arr[i]);

            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]); //지금까지 더한 값 또는 현재 값 비교

            // arr[i]로 다시 시작하면 그 값부터의 합을 구하는 거라서 
            
            max = Math.max(dp[i], max);
        }
        System.out.println(max);


    }
}