import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] paper;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

//        for (int[] i : paper)
//            System.out.println(Arrays.toString(i));

        answer = new int[2];

        int first = paper[0][0];

        boolean same = true;

        outer:
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (first != paper[i][j]) {
                    same = false;
                    check(0, 0, n / 2);
                    break outer;
                }
            }

        if (same) answer[first]++;


        System.out.print(answer[0] + "\n" + answer[1]);


    }

    private static void check(int r, int c, int len) {

        int first;
        boolean same;

        // 기저 조건
        if (len == 0) return;

        // 1사분면
        first = paper[r][c];
//        System.out.println(r + ", " + c);
//        System.out.println("first " + first);
        same = true;
        outer:
        for (int i = r; i < r + len; i++)
            for (int j = c; j < c + len; j++) {
                if (first != paper[i][j]) {
                    same = false;
                    check(r, c, len / 2);
                    break outer;
                }
            }
        if (same) answer[first]++;

        // 2사분면
        first = paper[r][c + len];
//        System.out.println(r + ", " + (c + len));
//        System.out.println("first " + first);
        same = true;
        outer:
        for (int i = r; i < r + len; i++)
            for (int j = c + len; j < c + len + len; j++) {
                if (first != paper[i][j]) {
                    same = false;
                    check(r, c + len, len / 2);
                    break outer;
                }
            }
        if (same) answer[first]++;


        // 3사분면
        first = paper[r + len][c + len];
//        System.out.println((r + len) + ", " + (c + len));
//        System.out.println("first " + first);
        same = true;
        outer:
        for (int i = r + len; i < r + len + len; i++)
            for (int j = c + len; j < c + len + len; j++) {
                if (first != paper[i][j]) {
                    same = false;
                    check(r + len, c + len, len / 2);
                    break outer;
                }
            }
        if (same) answer[first]++;

        // 4사분면
        first = paper[r + len][c];
//        System.out.println((r + len) + ", " + c);
//        System.out.println("first " + first);
        same = true;
        outer:
        for (int i = r + len; i < r + len + len; i++)
            for (int j = c; j < c + len; j++) {
                if (first != paper[i][j]) {
                    same = false;
                    check(r + len, c, len / 2);
                    break outer;
                }
            }
        if (same) answer[first]++;
    }
}