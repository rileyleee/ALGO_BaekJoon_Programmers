import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        //[] arr = new int[n];
        int [] conSum = new int[n];

        for (int i = 0; i < n; i++) {

            int thisNum = sc.nextInt();

            //arr[i] = thisNum;

            if (i == 0) {
                conSum[i] = thisNum;
            } else {
                conSum[i] = conSum[i - 1] + thisNum;
            }
        }

        //System.out.println(Arrays.toString(conSum));

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            int sum = 0;

            //System.out.println("s: " + s);
            //System.out.println("e-1: " + (e - 1));

            if (s == 1) {
                sum = conSum[e - 1];

                //System.out.println("sum: "+sum);

            } else {
                sum = conSum[e - 1] - conSum[s-2];
                //System.out.println("sum: "+sum);
            }

            sb.append(Integer.toString(sum)).append("\n");

        }

        System.out.println(sb.toString());


    }
}