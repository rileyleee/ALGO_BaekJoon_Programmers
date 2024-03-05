import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j - 1);
            }
        }

        while (t-- > 0) {
            int[][] acc = getPrefixSum(arr);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int aroundLives = getAroundLives(i, j, acc, k);
                    if (arr[i][j] == '*') {
                        aroundLives--; // 현재 본인은 제외
                        if (aroundLives < a || aroundLives > b) {
                            arr[i][j] = '.'; // 사망
                        }
                    } else if (aroundLives > a && aroundLives <= b) {
                        arr[i][j] = '*';
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static int getAroundLives(int r, int c, int[][] acc, int k) {

        int startR = Math.max(r - k, 1);
        int startC = Math.max(c - k, 1);
        int endR = Math.min(r + k, acc.length - 1);
        int endC = Math.min(c + k, acc[0].length - 1);

        return acc[endR][endC] - acc[startR - 1][endC] - acc[endR][startC - 1] + acc[startR - 1][startC - 1];
    }

    private static int[][] getPrefixSum(char[][] arr) {

        int[][] acc = new int[arr.length][arr[0].length];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + (arr[i][j] == '*' ? 1 : 0);
            }
        }

        return acc;
    }
}