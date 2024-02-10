import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String firstS, secondS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {

        int[] firstArr = new int[150];
        int[] secondArr = new int[150];

        // 카운팅 배열 활용
        for (int i = 0; i < firstS.length(); i++) {
            firstArr[firstS.charAt(i) - 0]++;
        }

        for (int i = 0; i < secondS.length(); i++) {
            secondArr[secondS.charAt(i) - 0]++;
        }

        int answer = 0;

        for (int i = 0; i < 150; i++) {
            answer += Math.abs(firstArr[i] - secondArr[i]);
        }

        System.out.println(answer);


    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        firstS = sc.next();
        secondS = sc.next();


    }
}