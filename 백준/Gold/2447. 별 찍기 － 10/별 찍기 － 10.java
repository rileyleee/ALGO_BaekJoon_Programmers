import java.util.Scanner;

public class Main {
    public static char[][] sky;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sky = new char[n][n];

        drawStars(0, 0, n, false);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(sky[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void drawStars(int x, int y, int n, boolean blank) {

        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    sky[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            sky[x][y] = '*';
            return;
        }

        int newN = n / 3;
        int count = 0;

        for (int i = x; i < x + n; i += newN) {
            for (int j = y; j < y + n; j += newN) {
                count++;
                if (count == 5) {
                    drawStars(i, j, newN, true);
                } else {
                    drawStars(i, j, newN, false);

                }
            }
        }
    }
}