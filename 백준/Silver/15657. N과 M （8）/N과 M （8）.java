import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static StringBuilder sb;
	static int[] arr, selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[n + 1];
		selected = new int[m + 1];

		for (int a = 1; a <= n; a++) {
			arr[a] = sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();

		rec(1, 1);
		System.out.println(sb.toString());
		sc.close();
	}

	private static void rec(int idx, int start) {
		// 기저조건
		if (idx == m + 1) {
			for (int s = 1; s <= m; s++) {
				sb.append(selected[s]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 유도조건
		for (int a = start; a <= n; a++) {
			selected[idx] = arr[a];
			rec(idx + 1, a); // 큰지 작은지 동일여부 상관없이 사용한 숫자부터 반복문 돌기 때문에 편리
		}
	}
}