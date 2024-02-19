import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int originalNum = sc.nextInt();

        int[] separatedNum = new int[2];

        if (originalNum < 10) {
            separatedNum[1] = originalNum;
        } else {
            separatedNum[0] = originalNum / 10;
            separatedNum[1] = originalNum % 10;
        }
        int a, temp, b;
        int ans = 0;

        while (true) {
            a = separatedNum[1];
            temp = separatedNum[0] + separatedNum[1];
            b = 0;

            if (temp < 10) {
                b = temp;
            } else {
                b = temp % 10;
            }
            separatedNum[0] = a;
            separatedNum[1] = b;
            ans++;

            if ((a * 10 + b) == originalNum) {
                break;
            }
        }

        System.out.println(ans);

    }
}