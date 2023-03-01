import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		int dCnt = 1;
		int max = 1;
		for (int n = 0; n < N - 1; n++) {
			// 작아지는 경우(같은 경우 포함) 카운트
			if (arr[n] >= arr[n + 1]) {
				dCnt++;
			} else {
				dCnt = 1;
			}
			max = (Math.max(max, dCnt));
		}
		int iCnt = 1;
		for (int n = 0; n < N - 1; n++) {
			// 커지는 경우 (같은 경우 포함) 카운트
			if (arr[n] <= arr[n + 1]) {
				iCnt++;
			} else {
				iCnt = 1;
			}
			max = (Math.max(max, iCnt));
		}
		System.out.println(max);
		sc.close();
	}
}