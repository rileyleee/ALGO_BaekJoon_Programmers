import java.util.Scanner;

public class Main {
    static String document, target;

    public static void main(String[] args) {

        input();
        solve();

    }

    private static void solve() {
        int startIdx = 0;
        int dIdx = 0;
        int tIdx = 0;
        int ans = 0;

        while (dIdx < document.length()) {

            //System.out.println("0) dIdx: " + dIdx);
            //System.out.println("0) tIdx: " + tIdx);

            if (document.charAt(dIdx) == target.charAt(tIdx)) {
                tIdx++;
                //System.out.println("1) dIdx: " + dIdx);
                //System.out.println("1) tIdx: " + tIdx);
                if (tIdx == target.length()) {
                    tIdx = 0;
                    ans++;
                    startIdx = dIdx;
                    //System.out.println("2) dIdx: " + dIdx);
                    //System.out.println("2) tIdx: " + tIdx);
                }
                dIdx++;
                //System.out.println("3) dIdx: " + dIdx);
                //System.out.println("3) tIdx: " + tIdx);
            } else {
                if (tIdx == 0) {

                    dIdx++;
                    startIdx = dIdx;
                    //System.out.println("4) dIdx: " + dIdx);
                    //System.out.println("4) tIdx: " + tIdx);
                } else {
                    tIdx = 0;
                    startIdx++;
                    dIdx = startIdx;
                    //System.out.println("5) dIdx: " + dIdx);
                    //System.out.println("5) tIdx: " + tIdx);
                }
            }

        }

        System.out.println(ans);


    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        document = sc.nextLine();

        target = sc.nextLine();
    }
}