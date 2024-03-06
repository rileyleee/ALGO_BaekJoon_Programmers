import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            int thisNum = sc.nextInt();
            boolean find = false;

            int l = 0;
            int r = arr.length - 1;

//            System.out.println("thisNum: " + thisNum);
//
//            System.out.println("===================================");

            while (l <= r) {
                int mid = (l + r) / 2;

//                System.out.println("l: " + l);
//                System.out.println("r: " + r);
//                System.out.println("mid: " + mid);

                if (arr[mid] < thisNum) l = mid + 1;
                else if (arr[mid] > thisNum) r = mid - 1;
                else if (arr[mid] == thisNum) {
                    sb.append(1 + "\n");
                    find = true;
                    break;
                }

            }
            if (!find) sb.append(0 + "\n");
        }

        System.out.println(sb);

    }

}