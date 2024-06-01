import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();

        int x = -1;
        int start;
        int len = -1;

        for (int i = L; i <= 100; i++) {
            start = (i - 1) * i / 2;
            if ((N - start) % i == 0) {
                x = (N - start) / i;
                len = i;
                break;
            }
        }

        if (x < 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < len; i++) {
                System.out.print(x + i + " ");
            }
        }
    }
}