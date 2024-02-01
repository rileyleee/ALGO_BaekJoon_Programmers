import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int n, cnt, max;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n][2];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		max = Integer.MIN_VALUE;
		int i = 0;
		// 첫 회의 기준 잡기
		cnt = 1;
		int k = i;
		int j = i + 1;
		while (j < n) {
			if (arr[k][1] <= arr[j][0]) {
				cnt++;
				k = j;
				j++;
			} else {
				j++;
			}
		}
		max = Math.max(max, cnt);
		System.out.println(max);
		sc.close();
	}
}