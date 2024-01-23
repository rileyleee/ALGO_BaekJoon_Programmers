import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int [][] stickers = new int[2][n+1];

            int [][] dp = new int [2][n+1];


            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = sc.nextInt();
                }
            }

            
            // 해당 위치의 스티커를 선택하는 경우 최대 점수
            // 스티커가 한 개일 때는 해당 스티커를 떼는 것이 최대 점수
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1] ;

            for(int i =2; i<=n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
                
                // 각 스티커를 선택했을 때 가질 수 있는 최대 점수는 인접한 칸 제외하고 
                // 좌하 좌상 대각선의 최종 합을 비교하여 최대값 산출
            }


            System.out.println(Math.max(dp[0][n], dp[1][n]));


        }
    }
}