import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] base = new long[n];

        for (int i = 0; i < n; i++) {
            base[i] = sc.nextLong();
        }

        Arrays.sort(base);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {

            long check = sc.nextLong();

            System.out.println(BinarySearch(base, check));
        }
    }

    private static int BinarySearch(long[] base, long check) {

        long left = 0; // 가장 작은 수의 인덱스
        long right = base.length - 1; // 가장 큰 수의 인덱스
        long mid; // 중간 값

        while (left <= right) {
            mid = (left + right) / 2;

            if (base[(int) mid] == check) {
                return 1;
            } else if (base[(int) mid] > check) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}