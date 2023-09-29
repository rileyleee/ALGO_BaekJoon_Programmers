import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        if (num != 1) {
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        sb.append(i + "\n");
                        num = num/i;
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}