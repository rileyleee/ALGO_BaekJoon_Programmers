import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] table = new int[m+1][m+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                table[i][j] = table[i][j-1]+sc.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            int sum = 0;
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j = x1; j<=x2; j++){
                sum= sum+(table[j][y2]-table[j][y1-1]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}