import java.util.Scanner;

public class Main {
    // 이분 탐색 + yes/no problem
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long q = 0L;

        if (n == 0) q = 0;

        else {

            long l = 0;
            long r = n;
            // 여기 r 값을 지정하기가 어려웠는데 n의 최대값이 2의 63승이기 때문에
            // 제곱근의 값이 될 최대값을 저렇게 비트 연산자로 나타낼 수 있다.

            while (l <= r) {

                long m = (l + r) / 2;

                if (Math.pow(m, 2) < n) {
                    l = m + 1;
                } else {
                    r = m - 1;
                    q = m;
                }
            }
        }
        System.out.println(q);
    }
}