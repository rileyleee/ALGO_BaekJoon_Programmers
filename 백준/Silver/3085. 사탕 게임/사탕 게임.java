import java.util.Scanner;

public class Main {
    public static int n, continuous;
    public static char[][] candies;


    public static void main(String[] args) {

        // 값 입력 받기
        input();

        // 사방탐색하며 바꿀 수 있는 경우 바꿔서 연속되는 수 구하기
        switchJustOne();
        System.out.println(continuous);

    }

    private static void switchJustOne() {

        continuous = 0;
        checkOriginalArray();

        int tempColCon;
        int tempRowCon;
        int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int d = 0; d < 4; d++) {
                    int nr = i + drc[d][0];
                    int nc = j + drc[d][1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                    if (candies[nr][nc] != candies[i][j]) {
                        char temp = candies[i][j];
                        candies[i][j] = candies[nr][nc];
                        candies[nr][nc] = temp;

                        // 교환한 채로 체크

                        tempRowCon = 1;
                        tempColCon = 1;
                        for (int k = 1; k < n; k++) {
                            if (candies[i][k - 1] == candies[i][k]) {
                                tempRowCon++;
                            } else {
                                tempRowCon = 1;
                            }
                            if (candies[k - 1][j] == candies[k][j]) {
                                tempColCon++;
                            } else {
                                tempColCon = 1;
                            }
                            continuous = Math.max(continuous, Math.max(tempRowCon, tempColCon));

                        }

                        // 원상복구
                        candies[nr][nc] = candies[i][j];
                        candies[i][j] = temp;
                    }
                }
            }
        }
    }

    private static void checkOriginalArray() {
        int tempRowCon = 1;
        int tempColCon = 1;

        for (int i = 0; i < n; i++) {
            tempRowCon = 1;
            tempColCon = 1;
            for (int k = 1; k < n; k++) {
                if (candies[i][k - 1] == candies[i][k]) {
                    tempRowCon++;
                } else {
                    tempRowCon = 1;
                }

                if (candies[k - 1][i] == candies[k][i]) {
                    tempColCon++;
                } else {
                    tempColCon = 1;
                }
                continuous = Math.max(continuous, Math.max(tempRowCon, tempColCon));
            }
        }
    }


    private static void input() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        candies = new char[n][n];

        for (int i = 0; i < n; i++) {
            candies[i] = sc.next().toCharArray();
        }
    }
}