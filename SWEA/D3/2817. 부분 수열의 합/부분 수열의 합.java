import java.util.Scanner;

public class Solution {
	static int n, k, cnt;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			int sum = 0;
			cnt = 0;
			arr = new int[n];

			for (int a = 0; a < arr.length; a++) {
				arr[a] = sc.nextInt();
			}
			powerset(0, sum);
			if (k == 0) {
				cnt--;
				System.out.println("#" + t + " " + cnt);
			} else {
				System.out.println("#" + t + " " + cnt);
			}
		}
		sc.close();
	}

	private static void powerset(int i, int sum) {
		// 기저조건

		if (sum > k) { //언제라도  합계가 기준을 넘으면 끝까지 볼 것도 없이 바로 종료 실행시간 단축
			return;
		}
		if (i == n) { // 모든 원소들을 순회하면서 수열에 포함여부를 다 결정했어 -> 부분 수열 완성
			if (sum == k) { // 그 수열들을 더한 값이 기준과 같으면
				cnt++; // 카운트 해주고
				return; // 현재 함수는 종료하고 호출했던 그 함수로 돌아가
			}
		} else {
			// 재귀조건
			powerset(i + 1, sum); // 수열에 포함되지 않는 경우로서 sum에 더하지 않음
			powerset(i + 1, sum + arr[i]); // 수열에 포함되는 경우로서 sum에 더함}
		}
	}
}