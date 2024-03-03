import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int m, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] growthHint = new int[n][3];
        int[][] larva = new int[m][m];


//        for (int i = 0; i < m; i++)
//            for (int j = 0; j < m; j++) {
//                larva[i][j] = 1;
//            }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            growthHint[i][0] = Integer.parseInt(st.nextToken());
            growthHint[i][1] = Integer.parseInt(st.nextToken());
            growthHint[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < growthHint[i - 1].length; j++) {
                for (int k = 0; k < growthHint[i - 1][j]; k++) {
                    sb.append(j + " ");
                }
            }

            String growthData = sb.toString();
            //System.out.println("그래서 어떻게 크는데: " + growthData);
            updateIndependentGrowth(growthData, larva);
        }

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

    private static void updateIndependentGrowth(String growthData, int[][] larva) {
        StringTokenizer st = new StringTokenizer(growthData);

        for (int i = m - 1; i >= 0; i--) {
            int thisNum = Integer.parseInt(st.nextToken());
            larva[i][0] += thisNum;
        }

        for (int i = 1; i <= m - 1; i++) {
            int thisNum = Integer.parseInt(st.nextToken());
            larva[0][i] += thisNum;
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(larva[i][j]);
//            }
//            System.out.println();
//        }

    }

    private static void updateDependentGrowth(int[][] larva) {

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                int max = checkAround(i, j, larva);

                larva[i][j] = max;
            }
        }


//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(larva[i][j]);
//            }
//            System.out.println();
//        }
    }


    private static int checkAround(int i, int j, int[][] onlyForTheDay) {

        return Math.max(onlyForTheDay[i][j - 1], Math.max(onlyForTheDay[i - 1][j], onlyForTheDay[i - 1][j - 1]));
    }
}