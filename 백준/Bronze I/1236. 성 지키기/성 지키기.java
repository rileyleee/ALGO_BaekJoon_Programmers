import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int n, m;
    public static boolean[][] arr;
    public static boolean[] rowArr, colArr;

    public static void main(String[] args) {
        input();
        solve();

    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new boolean[n][m];

        rowArr = new boolean[n];
        colArr = new boolean[m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                char thisPosition = str.charAt(j);
                if (thisPosition == 'X') {
                    arr[i][j] = true;
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }
    }

    private static void solve() {

        //System.out.println(Arrays.toString(rowArr));
        //System.out.println(Arrays.toString(colArr));

        int rNeed = 0;
        int cNeed = 0;

        for (int i = 0; i < n; i++) {
            if (!rowArr[i]) {
                rNeed++;
            }
        }

        for (int i = 0; i < m; i++) {
            if (!colArr[i]) {
                cNeed++;
            }
        }


        System.out.println(Math.max(rNeed, cNeed));
    }
}