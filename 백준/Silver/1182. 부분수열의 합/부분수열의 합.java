import java.util.Scanner;

public class Main {
	static int n;
	static int s;
	static int cnt;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		s = sc.nextInt();
		cnt = 0;
		arr = new int[n];

		for (int a = 0; a < arr.length; a++) {
			arr[a] = sc.nextInt();
		}

		int sum = 0;
		rec(0, sum);
		if (s == 0) {
			cnt--;
			System.out.println(cnt);
		} else {
			System.out.println(cnt);
		}
		sc.close();
	}

	private static void rec(int i, int sum) {

		if (i == n) { // 마지막 원소까지 다 돌면서 수열에 포함여부를 모두 결정하면 수열 완성!
			if (sum == s) { //수열의 합이 기준과 일치하면
				cnt++; // 카운트 해주기
			}
			return;
		} else {
			rec(i + 1, sum); // 수열에 포함하지 않기 때문에 기존 sum유지하기
			rec(i + 1, sum + arr[i]); // 수열에 포함하고 그 부분 합을 더해가기
		}
	}
}