import java.util.Scanner;

public class Main {
    static int[][] cal, arr;
    static int min, n, m, k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        cal = new int[k][3];

        for (int i = 0; i < k; i++) {
            cal[i][0] = sc.nextInt() - 1;
            cal[i][1] = sc.nextInt() - 1;
            cal[i][2] = sc.nextInt();
        }

        min = Integer.MAX_VALUE;

        getOrder(0, new int[k], new boolean[k]);

        System.out.println(min);
    }

    private static void getOrder(int s, int[] orders, boolean[] visited) {


        // 연산할 순서 구하기
        if (s == k) {
            rotate(orders);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            orders[s] = i;
            getOrder(s + 1, orders, visited);
            visited[i] = false;
        }

    }

    private static void rotate(int[] orders) {
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) { // 깊은 복사
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < k; i++) { // 연산 순서대로 회전하기
            int r = cal[orders[i]][0];
            int c = cal[orders[i]][1];
            int s = cal[orders[i]][2];


            for (int j = 1; j <= s; j++) {

                // 상
                int upTmp = tmp[r - j][c + j];
                for (int y = c + j; y > c - j; y--) {
                    tmp[r - j][y] = tmp[r - j][y - 1];
                }

                // 우
                int rightTmp = tmp[r + j][c + j];
                for (int x = r + j; x > r - j; x--) {
                    tmp[x][c + j] = tmp[x - 1][c + j];
                }
                //회전한 행의 가장 위에 upTmp 값
                tmp[r - j + 1][c + j] = upTmp;

                // 하
                int leftTmp = tmp[r + j][c - j];
                for (int y = c - j; y < c + j; y++) {
                    tmp[r + j][y] = tmp[r + j][y + 1];
                }
                //회전한 행의 가장 오른쪽에 rightTmp 값
                tmp[r + j][c + j - 1] = rightTmp;

                // 좌
                for (int x = r - j; x < r + j; x++) {
                    tmp[x][c - j] = tmp[x + 1][c - j];
                }
                //회전한 행의 가장 왼쪽에 leftTmp 값
                tmp[r + j - 1][c - j] = leftTmp;
            }
        }

        getAnswer(tmp);

    }

    private static void getAnswer(int[][] tmp) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += tmp[i][j];
            }
            if (min > sum) min = sum;
        }
    }
}