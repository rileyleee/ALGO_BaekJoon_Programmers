import java.util.Scanner;

public class Main {
    static int[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        arr = new int[41][2];

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        int tc = sc.nextInt();

        for (int i = 2; i < 41; i++) {
            arr[i][0] = -1;
            arr[i][1] = -1;
        }

        for (int i = 0; i < tc; i++) {

            int num = sc.nextInt();
            func(num);

            System.out.println(arr[num][0] + " " + arr[num][1]);
        }
    }

    private static int[] func(int num) {

        if (arr[num][0] == -1 || arr[num][1] == -1) {

            arr[num][0] = func(num - 1)[0] + func(num - 2)[0];
            arr[num][1] = func(num - 1)[1] + func(num - 2)[1];
        }

        return arr[num];
    }


}