import java.util.*;

public class Main {
    public static void main(String[] args) {


        // Scanner로 동굴의 길이와 높이를 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] barrierUp = new int[h + 1];
        int[] barrierDown = new int[h + 1];

        int len;

        // 각 열별로 석순 종유석 석순의 순서로 길이가 주어짐
        for (int i = 0; i < n; i++) {
            len = sc.nextInt();
            // 동굴의 길이는 항상 짝수이므로 0과 짝수열은 석순, 홀수열은 종유석
            // 석순은 큰행부터 채우고 종유석은 작은행(0행)부터 채운다
            if (i == 0 || i % 2 == 0) { // 석순
                barrierUp[len]++;
            } else { // 종유석
                barrierDown[h - len + 1]++;
            }
        }
//
//        System.out.println(Arrays.toString(barrierUp));
//        System.out.println(Arrays.toString(barrierDown));

        for (int i = h; i > 1; i--) {
            barrierUp[i - 1] += barrierUp[i];
        }

        for (int i = 1; i < h; i++) {
            barrierDown[i + 1] += barrierDown[i];
        }

//        System.out.println(Arrays.toString(barrierUp));
//        System.out.println(Arrays.toString(barrierDown));

        int[] ans = new int[h + 1];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= h; i++) {
            ans[i] = barrierUp[i] + barrierDown[i];
            min = Math.min(min, ans[i]);
        }

        int count = 0;
        for (int i = 1; i <= h; i++) if (ans[i] == min) count++;

        System.out.println(min + " " + count);


    }
}