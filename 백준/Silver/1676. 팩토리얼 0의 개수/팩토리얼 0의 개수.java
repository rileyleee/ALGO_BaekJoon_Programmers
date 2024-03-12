import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;

        while (n >= 5) { // 0의 개수는 2와 5에 의해 결정되는데
            cnt += n / 5; // 2보다 5의 갯수가 적고 이로부터 0의 개수가 결정됨
            n /= 5;
        }

        System.out.println(cnt);
    }
}