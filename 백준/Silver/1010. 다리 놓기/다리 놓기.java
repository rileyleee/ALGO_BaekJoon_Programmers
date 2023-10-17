import java.util.Scanner;

public class Main {
    static int[][] dp = new int[30][30];
    ;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt(); //m과 같거나 작은 수
            int m = sc.nextInt();

            //최대 갯수는 n개이고
            //다리끼리는 겹쳐질 수 없다.
            //동쪽 다리인 m개에서 1부터 작은 수 순서대로 n개 만큼 고르는 경우의 수

            sb.append(pick(m, n) + "\n");

        }
        System.out.println(sb.toString());
    }

    static int pick(int m, int n) {

        if (dp[m][n] > 0) { //이미 알고있는 값이면 바로 출력
            return dp[m][n];
        }

        if (m == n || n == 0) { //다리 수가 같으면 경우의 수는 1임
            return dp[m][n] = 1;
        } else {
            dp[m][n] = pick(m - 1, n - 1) + pick(m - 1, n);
            // 여기서 배열에 미리 담아서 시간 초과 방지
            return pick(m - 1, n - 1) + pick(m - 1, n);
        }
    }

}