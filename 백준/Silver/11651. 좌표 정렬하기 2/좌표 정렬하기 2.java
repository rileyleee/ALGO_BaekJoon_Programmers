import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        while (n-- > 0) {
            arr[n][0] = sc.nextInt();
            arr[n][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int[] i : arr) {
            sb.append(i[0] + " " + i[1] + "\n");
        }

        System.out.println(sb);

    }
}