import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            long s = sc.nextLong();
            long e = sc.nextLong();
            sb.append(Integer.toString(check(arr, s, e))).append("\n");
            //System.out.println("======================");
        }

        System.out.println(sb.toString());
    }

    private static int check(long[] arr, long s, long e) {
        int first = findS(arr, s);
        int last = findE(arr, e);

//        System.out.println("first: " + first);
//        System.out.println("last: " + last);

        return last - first;
    }


    private static int findS(long[] arr, long s) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            //System.out.println("Start_left: "+ left);
            //System.out.println("Start_right: "+ right);

            int mid = (left + right) / 2;
            //System.out.println("Start_mid: "+ mid);

            if (arr[mid] < s) {
                left = mid + 1;

            } else {
                right = mid - 1;

            }
        }
        return left;
    }

    private static int findE(long[] arr, long e) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            //System.out.println("End_left: "+ left);
            //System.out.println("End_right: "+ right);

            int mid = (left + right) / 2;
            //System.out.println("Start_mid: "+ mid);

            if (arr[mid] > e) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right+1;
    }

}