import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr, selected;
	static boolean[] used;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1];
		selected = new int[m + 1];
		int max = Integer.MIN_VALUE;
		for (int a = 1; a <= n; a++) {
			arr[a] = sc.nextInt();
			max = Math.max(max, arr[a]);
		}
		used = new boolean[max + 1];
		Arrays.sort(arr);
		sb = new StringBuilder();
		rec(1);
		System.out.println(sb.toString());
		sc.close();
	}

	private static void rec(int idx) {
		// 기저조건
		if (idx == m + 1) {
			for (int s = 1; s <= m; s++) {
				sb.append(selected[s]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 유도조건
		for (int a = 1; a <= n; a++) {
			if (used[arr[a]]) {
				continue;
			}
			selected[idx] = arr[a];
			used[arr[a]] = true;
			rec(idx + 1);
			used[arr[a]] = false;
		}
	}
}