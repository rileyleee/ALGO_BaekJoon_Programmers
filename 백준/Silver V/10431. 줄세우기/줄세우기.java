import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static int thisT;
    public static int[] height;

    public static void main(String[] args) {

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            solve();
        }
    }

    private static void solve() {

        height = new int[20];

        int howMany = 0;

        for (int i = -1; i < 20; i++) {

            if (i == -1) {
                thisT = sc.nextInt();
            } else {
                height[i] = sc.nextInt();
            }
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] < height[j]) {
                    howMany++;
                }
            }
        }

        System.out.println(thisT+" "+howMany);

    }


}