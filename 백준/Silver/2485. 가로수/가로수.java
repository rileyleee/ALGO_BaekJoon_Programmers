import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] tree = new int[n];
        int[] diff = new int[n - 1];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();

            if (i > 0) {
                diff[i - 1] = tree[i] - tree[i - 1];
            }

        }

        //System.out.println(Arrays.toString(diff));

        // 각 가로수 간 거리 차의 최대 공약수를 구하기

        int gcdNum = diff[0];

        for (int i = 1; i < diff.length; i++) {
            gcdNum = gcd(gcdNum, diff[i]);
        }

        // System.out.println("최대공약수: " + gcdNum);

        int answer = tree[n - 1] - tree[0];

        System.out.println(answer/gcdNum-n+1);

    }

    private static int gcd(int a, int b) {

        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}