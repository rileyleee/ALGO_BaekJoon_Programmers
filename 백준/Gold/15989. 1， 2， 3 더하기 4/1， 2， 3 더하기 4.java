import java.util.Scanner;

public class Main {
    public static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];


        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        findNum(max);


        for (int i = 0; i < n; i++) {
            System.out.println(dp[arr[i]]);
        }

    }

    private static void findNum(int max) {


        dp = new int[max + 1];

        dp[1] = 1;

        for (int target = 2; target <= max; target++) {
//            System.out.println("=============================");
//            System.out.println("타겟 숫자는: " + target);

            int cnt = 0;

            // 2를 기준으로 시작
            for (int two = 0; two <= target / 2; two++) {

                int newNum = target - (two * 2);

                //System.out.println("이번 2의 갯수:" + two);

                if (newNum == 0) {
                    //System.out.println("딱 떨어져서 cnt++ 합니다.");
                    cnt++;
                } else if (newNum > 0 && newNum % 3 == 0) {
                    cnt++;
                    //System.out.println("2가 " + two + "일 때 3은" + newNum / 3 + "개 이다");
                }

            }
            //System.out.println(target + "숫자에 대한 추가 조합: " + cnt);
            dp[target] = dp[target - 1] + cnt;


        }
    }


}