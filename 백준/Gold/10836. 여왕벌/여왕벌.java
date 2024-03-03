import java.io.*;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int m, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] totalGrowth = new int[2 * m + 1];
        int[][] larva = new int[m][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            totalGrowth[first + 1] += 1;
            totalGrowth[first + 1 + second] -= 1; // -1 복원처리
            totalGrowth[first + 1 + second] += 2;// +2 반영
            totalGrowth[first + 1 + second + third] -= 2;


            //System.out.println(Arrays.toString(totalGrowth));

            //System.out.println("======================================");
        }


        //System.out.println(Arrays.toString(totalGrowth));

        for (int i = 1; i < totalGrowth.length; i++) {
            totalGrowth[i] = totalGrowth[i - 1] + totalGrowth[i];
        }

        //System.out.println(Arrays.toString(totalGrowth));


        updateIndependentGrowth(totalGrowth, larva);

        updateDependentGrowth(larva);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(larva[i][j] + 1 + " ");
            }
            bw.write("\n");
        }

        bw.flush();

    }

    private static void updateIndependentGrowth(int[] totalGrowth, int[][] larva) {
        int idx = 1;
        for (int i = m - 1; i >= 0; i--) {
            larva[i][0] = totalGrowth[idx++];
        }

        for (int i = 1; i <= m - 1; i++) {
            larva[0][i] = totalGrowth[idx++];
        }

    }

    private static void updateDependentGrowth(int[][] larva) {

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                int max = checkAround(i, j, larva);

                larva[i][j] = max;
            }
        }
    }


    private static int checkAround(int i, int j, int[][] onlyForTheDay) {

        return Math.max(onlyForTheDay[i][j - 1], Math.max(onlyForTheDay[i - 1][j], onlyForTheDay[i - 1][j - 1]));
    }
}