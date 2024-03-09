import java.util.Scanner;

public class Main {
    static int GCNum = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        getGCD(a, b);

        int LCNum = (a * b) / GCNum;


        System.out.print(GCNum + "\n" + LCNum);

    }

    private static void getGCD(int a, int b) {

        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (b == 0) {
            GCNum = a;
            return;
        }
        int remain = a % b;
        a = b;
        b = remain;

        getGCD(a, b);

    }
}