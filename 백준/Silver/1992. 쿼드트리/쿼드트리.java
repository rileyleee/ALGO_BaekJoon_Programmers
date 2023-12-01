import java.util.Scanner;

public class Main {
    static int n;
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j);
            }
        }

        dAndC(0, 0, n);
        System.out.println(sb);

    }

    private static void dAndC(int x, int y, int len) {

        if (check(x, y, len)) { // 계속 같으면 값 넣음
            sb.append(video[x][y]-48);
            return;
        }

        sb.append("(");
        int newLen = len / 2;
        dAndC(x, y, newLen); // 1사분면
        dAndC(x, y + newLen, newLen); // 4사분면
        dAndC(x + newLen, y, newLen); // 2사분면
        dAndC(x + newLen, y + newLen, newLen); //3사분면
        sb.append(")");
    }

    private static boolean check(int x, int y, int len) {
        int first = video[x][y];

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (video[i][j] != first) { // 같지 않으면
                    return false; // 이번에는 값을 더하지 않음
                }
            }
        }
        return true;
    }


}