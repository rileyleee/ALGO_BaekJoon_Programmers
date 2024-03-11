import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, totalBudget;
    public static int[] budgetList;


    public static void main(String[] args) throws IOException {
        input();

        if (totalBudget <= m) {
            System.out.println(budgetList[n - 1]);
        } else {

            int max = Integer.MIN_VALUE;
            int maxUpperBound = 0;

            int l = 0;
            int r = budgetList[n - 1];

            while (l <= r) {

                int mid = (l + r) / 2;
                int upperBound = mid;

                int tempSum = 0;
                for (int i = 0; i < n; i++) {
                    tempSum += budgetList[i] > upperBound ? upperBound : budgetList[i];
                }


                if (tempSum > m) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

                if (tempSum <= m && tempSum > max) {
                    max = tempSum;
                    maxUpperBound = upperBound;
                }
            }
            System.out.println(maxUpperBound);
        }
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        budgetList = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            budgetList[i] = Integer.parseInt(st.nextToken());
            totalBudget += budgetList[i];
        }

        Arrays.sort(budgetList);

        m = Integer.parseInt(br.readLine());

        br.close();
    }

}