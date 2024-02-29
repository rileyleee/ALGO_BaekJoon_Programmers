import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLen = sc.nextInt();
        int queryLen = sc.nextInt();

        int[] arr = new int[arrLen + 1];
        for (int i = 0; i < arrLen; i++) {
            arr[i + 1] = arr[i] ^ sc.nextInt();
        }

        //System.out.println(Arrays.toString(arr));

        int result = 0;
        for (int i = 0; i < queryLen; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            result = result ^ (arr[first-1] ^ arr[second]);

            //System.out.println("result: " + result);
        }

        System.out.println(result);

    }

}