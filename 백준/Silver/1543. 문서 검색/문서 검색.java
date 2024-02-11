import java.util.Scanner;

public class Main {
    static String document, target;

    public static void main(String[] args) {

        input();
        solve();

    }

    private static void solve() {
        //System.out.println("변경 전 문서: " + document);

        document = document.replace(target, "*");

        int ans = 0;

        for (int i = 0; i < document.length(); i++) {
            if (document.charAt(i) == '*') {
                //System.out.println("찾았어요");
                ans++;
            }
        }
        //System.out.println("변경된 문서: " + document);
        //System.out.println("대상 단어: " + target);
        System.out.println(ans);

    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        document = sc.nextLine();

        target = sc.nextLine();
    }
}