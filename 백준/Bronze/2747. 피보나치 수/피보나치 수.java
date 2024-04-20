import java.util.Scanner;

public class Main {
    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n + 2];
        arr[0] = 0;
        arr[1] = 1;
        pibo(2, n);

        System.out.println(arr[n]);
    }

    private static void pibo(int num, int n) {
        if (num == n + 1) return;

        arr[num] = arr[num - 1] + arr[num - 2];
        pibo(num+1, n);
    }
}