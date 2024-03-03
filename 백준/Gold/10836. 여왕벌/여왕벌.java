import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int m, n;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        int[][] growthHint = new int[n][3];
        int[][] larva = new int[m][m];


        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++) {
                larva[i][j] = 1;
            }

        for (int i = 0; i < n; i++) {
            int zero = sc.nextInt();
            int one = sc.nextInt();
            int two = sc.nextInt();

            growthHint[i][0] = zero;
            growthHint[i][1] = one;
            growthHint[i][2] = two;
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
            updateIndependentGrowth(growthData, larva, i);
        }

        //System.out.println("그래서 최종 결과는 뭐야");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(larva[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();


    }

    private static void updateIndependentGrowth(String growthData, int[][] larva, int day) {
        StringTokenizer st = new StringTokenizer(growthData);

        int[][] onlyForTheDay = new int[m][m];

        for (int i = m - 1; i >= 0; i--) {
            int thisNum = Integer.parseInt(st.nextToken());
            larva[i][0] += thisNum;
            onlyForTheDay[i][0] = thisNum;
        }

        for (int i = 1; i <= m - 1; i++) {
            int thisNum = Integer.parseInt(st.nextToken());
            larva[0][i] += thisNum;
            onlyForTheDay[0][i] = thisNum;
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(larva[i][j]);
//            }
//            System.out.println();
//        }

        updateDependentGrowth(larva, onlyForTheDay, day);
    }

    private static void updateDependentGrowth(int[][] larva, int[][] onlyForTheDay, int day) {
//        System.out.println("================================");
//        System.out.println("동일한가유");
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(larva[i][j]);
//            }
//            System.out.println();
//        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                int max = checkAround(i, j, onlyForTheDay);

                larva[i][j] += max;
                onlyForTheDay[i][j] = max;
            }
        }
//        System.out.println("=================================");
//        System.out.println("여기 성장 차이만 보여주는 거임");
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(onlyForTheDay[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static int checkAround(int i, int j, int[][] onlyForTheDay) {

        return Math.max(onlyForTheDay[i][j - 1], Math.max(onlyForTheDay[i - 1][j], onlyForTheDay[i - 1][j - 1]));
    }
}