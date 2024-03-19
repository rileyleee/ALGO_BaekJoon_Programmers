import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student = sc.nextInt();
        int color = sc.nextInt();

        int[] jewels = new int[color];

        for (int i = 0; i < color; i++) {
            jewels[i] = sc.nextInt();
        }

        Arrays.sort(jewels);
        //System.out.println(Arrays.toString(jewels));

        // 질투심 즉, 한 아이가 가질 수 있는 최대 사탕의 수를 구하는 것
        int l = 1;
        int r = jewels[color - 1]; // 가장 많은 사탕 갯수가 있는 종류를 한 아이가 다 가지면 최대값

        int ans = -1;

        while (l <= r) {
            int m = (l + r) / 2;

            int tmp = getCnt(m, jewels);

            if (tmp <= student) {
                ans = m;
                r = m - 1;
                //System.out.println("r 줄임: " + r);
            } else {
                l = m + 1;
                //System.out.println("l 늘림: " + l);
            }
        }
        System.out.println(ans);
    }

    private static int getCnt(int m, int[] jewels) {
        //System.out.println("현재 m: " + m);
        int cnt = 0;
        for (int i = 0; i < jewels.length; i++) {
            if (jewels[i] % m != 0) cnt += (jewels[i] / m) + 1;
            else cnt += jewels[i] / m;
            //System.out.println("현재 cnt: " + cnt);
        }

        return cnt;
    }
}