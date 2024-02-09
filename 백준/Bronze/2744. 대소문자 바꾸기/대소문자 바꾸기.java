import java.util.Scanner;

public class Main {
    static String targetStr;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {

        String ans = "";


        for (int i = 0; i < targetStr.length(); i++) {
            if ('A' <= targetStr.charAt(i) && targetStr.charAt(i) <= 'Z') {
                // 각 더하기 연산은 char를 아스키 코드로 변환하여 계산하기 때문에
                // 대문자일 경우 A로부터 얼마나 거리가 떨어져 있는지 차이를 구하고
                // 소문자 a로부터 떨어진 거리를 더해주면 해당 아스키 코드를 가진 소문자가 된다
                // 이를 다시 char로 캐스팅하면 문자로 출력 가능
                ans += (char) ('a' + targetStr.charAt(i) - 'A');
            } else {
                ans += (char) ('A' + targetStr.charAt(i) - 'a');
            }
        }

        System.out.println(ans);

    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        targetStr = sc.next();

    }
}