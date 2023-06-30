import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            StringBuilder sb = new StringBuilder();

            int h = sc.nextInt(); //행, 호텔 높이
            int w = sc.nextInt(); //열, 호텔 너비
            int n = sc.nextInt(); //입실 순서

            int x = n % h; //층수 나머지 구하기
            int y = n / h; //호수 몫 구하기

            if (x == 0) { // 나머지가 0이면
                x = h; // 최고 층수
            }
            sb.append(x);

            if (x != h) { // 최고층이 아니라면 한 호수 넘어가야 하니까
                y++;
            }

            if (y == w) {// 몫이 너비와 동일하면
                y = w; // 제일 마지막 호수
            }

            if (y < 10 && y != 0) { //최대 호수가 두자리 수인데 묵을 방이 한 자리 수이면 0 더해주기
                sb.append(0).append(y);
            } else {
                sb.append(y);
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}