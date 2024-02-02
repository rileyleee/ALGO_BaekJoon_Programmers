import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        int con = 0;

        if (n == 1) {
            dp[1] = arr[1];
        }

        if (n == 2) {
            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];
        }


        if (n > 2) {

            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];

            if (arr[1] != 0) {
                con = 1;
                if (arr[2] != 0) {
                    con = 2;
                }
            } else {
                if (arr[2] != 0) {
                    con = 1;
                }
            }

            for (int i = 3; i <= n; i++) {

                con++;
                //System.out.println("이번 i: " + i);

                if (con == 3) {

                    int op1 = dp[i - 1];

                    int op2 = dp[i - 2] + arr[i];

                    int op3 = dp[i - 3] + arr[i - 1] + arr[i];

                    if (op1 >= op2 && op1 >= op3) {
                        con = 0;
                        dp[i] = op1;
                        //System.out.println("op1: " + op1);
                    }

                    if (op2 > op1 && op2 >= op3) {
                        con = 1;
                        dp[i] = op2;
                        //System.out.println("op2: " + op2);
                    }

                    if (op3 > op1 && op3 > op2) {
                        con = 2;
                        dp[i] = op3;
                        //System.out.println("op3: " + op3);
                    }

                } else {
                    dp[i] = dp[i - 1] + arr[i];
                }
                //System.out.println("dp[" + i + "]: " + dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}