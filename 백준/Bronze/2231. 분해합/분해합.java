import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int ans = -1;
        int eachNums = 0;
        String numStr = "";

        for (int j = 1; j <= n; j++) {
            eachNums = 0;

            numStr = Integer.toString(j);

            for (int i = 0; i < numStr.length(); i++) {
                eachNums += numStr.charAt(i) - '0';
            }

            if ((eachNums + j) == n) {
                ans = j;
                break;
            }
        }


        System.out.println(ans == -1 ? 0 : ans);
    }
}