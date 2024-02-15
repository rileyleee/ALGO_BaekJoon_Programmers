import java.util.Scanner;

public class Main {
    public static int n, x;
    public static boolean[] exist;

    public static void main(String[] args) { // 카운팅 배열을 이용한 풀이
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        exist = new boolean[1000001];

        // 존재하면 true로 변경
        for (int i = 0; i < n; i++) {
            exist[sc.nextInt()] = true;
        }


        x = sc.nextInt();
    }

    private static void solve() {

        int ans = 0;

        // 1부터 절반까지 순회하면서
        // 기준 숫자와 x-기준숫자가 둘다 존재하면 ans에 값을 더해줌
        // 이 때 x/2가 아니라 (x-1)/2라고 하는 이유는 x가 짝수일 때 같은 수로 합을 만드는 경우를 배제하기 위함임

        for (int i = 1; i <= (x - 1) / 2; i++) {

            if (i <= 1000000 && x - i <= 1000000) {
                ans += (exist[i] && exist[x - i]) ? 1 : 0;
            }
        }


        System.out.println(ans);

    }
}