import java.util.Scanner;

public class Main {
    // 에라토스테네스의 체 사용 // 이렇게 풀면 시간복잡도 O(nlog(logn))
    // "소수인 수"의 "배수를 지우면" "남은 건 소수"인 것을 이용
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int m = sc.nextInt();
        int n = sc.nextInt();

        isPrime = new boolean[n + 1]; // n까지 확인하기 위함

        for(int i =0; i<=n; i++){
            isPrime[i] = true;
        }

        // 0과 1은 소수가 아님
        isPrime[0] = false;
        isPrime[1] = false;

        checkPrime(n);

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) { // 소수이면
                System.out.println(i);
            }
        }

    }

    private static void checkPrime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) { // n 의 제곱근까지
            if (isPrime[i]) { // 소수이면 그 수의 배수를 소수에서 제외하기
                for (int j = i * i; j < isPrime.length; j = j + i) {
                    isPrime[j] = false;
                    // 여기서 j가 i*i부터 시작하는 이유
                    // 만약 i가 5라고 가정했을 때, 5의 배수인 10, 15, 20은 이미
                    // 이전 소수인 2와 3에 의해서 지워졌기 때문에 i*i부터 시작함
                }
            }
        }
    }
}