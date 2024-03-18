import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int f = sc.nextInt();

        // 두의 두 자리는 00으로 만들어서 시작
        n /= 100;
        n *= 100;

        int ans = 0;
        // 이번 숫자가 f로 나누어 떨어지지 않으면
        while (n % f != 0) { // 하나씩 올려줌 // 나누어떨어지는 순간 가장 작은 수임
            n++;
            ans++;
        }
        if (ans < 10) {
            System.out.print("0" + ans);
        } else {
            System.out.print(ans);
        }
    }
}