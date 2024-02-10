import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String firstS, secondS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {

        char[] firstChar = firstS.toCharArray();
        char[] secondChar = secondS.toCharArray();

        Arrays.sort(firstChar);
        Arrays.sort(secondChar);

        int i = 0;

        int idx = 0;
        int answer = 0;

        while (i < firstChar.length && idx < secondChar.length) {

            if (firstChar[i] - 0 != secondChar[idx] - 0) {
                if (firstChar[i] - 0 > secondChar[idx] - 0) {
                    idx++;
                }else{
                    i++;
                }
                answer++;
            } else {
                idx++;
                i++;
            }
        }

        answer += (secondChar.length - idx);
        answer += (firstChar.length - i);

        System.out.println(answer);


    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        firstS = sc.next();
        secondS = sc.next();


    }
}