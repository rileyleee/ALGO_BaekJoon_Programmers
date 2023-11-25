import java.util.Scanner;

public class Main {

    static int answer, h, w, n;
    static int[][] stickers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        n = sc.nextInt();

//        System.out.println("h: "+ h);
//        System.out.println("w: "+ w);
//        System.out.println("n: "+ n);

        stickers = new int[n][3];

        for (int i = 0; i < n; i++) {
            stickers[i][0] = sc.nextInt(); // 가로
            stickers[i][1] = sc.nextInt(); // 세로
            stickers[i][2] = (stickers[i][0] * stickers[i][1]); //스티커 넓이

//            System.out.println("가로: "+ stickers[i][0]);
//            System.out.println("세로: "+ stickers[i][1]);
//            System.out.println("넓이: "+ stickers[i][2]);
        }

        answer = 0;

        getMaxArea();

        System.out.println(answer);

    }

    private static void getMaxArea() { // 가지고 있는 스티커 중 2개만 붙이기 때문
        for (int i = 0; i < stickers.length; i++) {
            for (int j = i + 1; j < stickers.length; j++) {
                if (possible(stickers[i], stickers[j])) {
                    answer = Math.max(answer, stickers[i][2] + stickers[j][2]); // 미리 계산한 넓이 더하기
                }
            }
        }
    }

    private static boolean possible(int[] firstS, int[] secondS) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) { // 붙일 용지의 경계를 넘느냐 여부를 확인, 회전해서 한번이라도 true에 걸리면 true 반환
                if ((firstS[i] + secondS[j]) <= h && Math.max(firstS[(i + 1) % 2], secondS[(j + 1) % 2]) <= w)
                    return true;
                if ((firstS[i] + secondS[j]) <= w && Math.max(firstS[(i + 1) % 2], secondS[(j + 1) % 2]) <= h)
                    return true;
            }
        }
        return false;
    }
}