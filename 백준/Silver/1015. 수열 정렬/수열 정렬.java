import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] A = new int[n][2];

        for (int i = 0; i < n; i++) {
            A[i][0] = i;
            A[i][1] = sc.nextInt();
        }


//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(A[i]));
//        }


        Arrays.sort(A, Comparator.comparingInt(arr -> arr[1]));

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(A[i]));
//        }

        int[] newArr = new int[n];


        for (int i = 0; i < n; i++) {
            newArr[A[i][0]] = i;
        }

        String ans = "";

        for (int i = 0; i < n; i++) {
            ans += newArr[i] + " ";
        }

        System.out.println(ans);
    }
}