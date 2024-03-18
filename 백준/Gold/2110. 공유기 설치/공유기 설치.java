import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }

        Arrays.sort(houses);
        //System.out.println(Arrays.toString(houses));

        int l = 1;
        int r = houses[n - 1] - houses[0];
        int ans = -1;
        // 구하고자 하는 공유기 간의 거리를 이분 탐색의 대상으로 잡고!

        while (l <= r) {
            int m = (l + r) / 2;

            if (installedNum(m, houses) >= c) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(ans);
    }

    private static int installedNum(int m, int[] houses) {
        int cnt = 1;

        int before = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - before >= m) {
                cnt++;
                before = houses[i];
            }
        }
        return cnt;
    }
}