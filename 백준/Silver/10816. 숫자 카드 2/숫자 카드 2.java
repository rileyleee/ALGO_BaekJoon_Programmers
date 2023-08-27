import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 숫자 카드2
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] sg = new int[20000001];

        for (int i = 0; i < n; i++) { //음수 처리를 위함
            sg[sc.nextInt() + 10000000]++;
        }

        int m = sc.nextInt();

        int[] check = new int[m];

        for (int i = 0; i < m; i++) {
            check[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < check.length; i++) {
            sb.append(sg[check[i]+10000000]).append(" ");
        }

        System.out.println(sb.toString());

    }


}