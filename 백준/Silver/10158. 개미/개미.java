import java.util.Scanner;

public class Main {
    public static int w, h, p, q, t;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        w = sc.nextInt();
        h = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        t = sc.nextInt();
    }

    private static void solve() {

        int firstW = w - p;
        int firstH = h - q;

        while (firstW <= t) {
            firstW += 2 * w;
        }

        int ansW = Math.abs(w - (firstW - t));

        while (firstH <= t) {
            firstH += 2 * h;
        }

        int ansH = Math.abs(h - (firstH - t));

        System.out.println(ansW + " " + ansH);


    }
}