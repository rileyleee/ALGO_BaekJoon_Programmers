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
		used = new boolean[n + 1];
		selected = new int[m + 1];

		for (int a = 1; a <= n; a++) {
			arr[a] = sc.nextInt();
		}

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
		int tmp = 0;
		for (int a = 1; a <= n; a++) {
			if (used[a] || tmp == arr[a]) { 
                // 인덱스 기준으로는 사용하지 않았지만 전에 사용한 값과 같으면 지나가
				continue;
			}
			selected[idx] = arr[a];
			tmp = arr[a]; // 값으로 저장
			used[a] = true; // 해당 인덱스 사용했다는 표시 -> 인덱스와 값을 분리해서 체크

			rec(idx + 1);
			used[a] = false;
		}
	}
}