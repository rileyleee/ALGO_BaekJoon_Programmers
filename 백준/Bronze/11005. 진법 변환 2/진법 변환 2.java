import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int remaining = 0;


        StringBuilder sb = new StringBuilder();

        while (n >= b) {

            remaining = n % b;

            n /= b;

            //System.out.println("remaining: " + remaining);
            //System.out.println("n: " + n);

            if (remaining >= 10) {
                // 10에 55를 더하면 65니까 'A'
                remaining += 55;
                sb.append((char) remaining);
            } else {
                sb.append(remaining);
            }

        }
        if (n >= 10) {
            n += 55;
            sb.append((char) n);
        } else {
            sb.append(n);
        }


        System.out.println(sb.reverse().toString());
    }
}