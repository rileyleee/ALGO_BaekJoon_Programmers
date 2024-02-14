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
                howMany += reordering(i);
            }
        }
        System.out.println(thisT + " " + howMany);
    }

    private static int reordering(int idx) {
        int targetNum = height[idx];
        int thisMove = 0;

        for (int i = 0; i < 20; i++) {
            if (height[i] != 0 && height[i] > height[idx]) {
//                System.out.println("height[i]: " + height[i]);
//                System.out.println("height[idx]: " + height[idx]);
//                System.out.println("=========================================");
                for (int j = 19; j > i; j--) {

                    if (height[j] != 0) {
                        height[j] = height[j - 1];
                        thisMove++;
                    }
                }
                height[i] = targetNum;
//                System.out.println("이번 이동 수: " + thisMove);
            }
        }
        return thisMove;
    }
}