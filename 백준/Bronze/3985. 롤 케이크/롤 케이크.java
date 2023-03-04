import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int[] rollcake = new int[L + 1];
		int num = sc.nextInt();
		int[] diff = new int[num + 1];
		int people = 0;
		for (int n = 1; n <= num; n++) {
			people++;
			int p = sc.nextInt();
			int k = sc.nextInt();
			diff[n] = k - p + 1;
			for (int d = p; d <= k; d++) {
				if (rollcake[d] == 0) {
					rollcake[d] = people;
				}
			}
		}
		int max = 0;
		int maxIdx = -1;
		for (int d = 0; d < diff.length; d++) {
			if (diff[d] > max) {
				max = diff[d];
				maxIdx = d;
			}
		}
		System.out.println(maxIdx);
		int[] cnt = new int[num + 1];

		int realMax = 0;
		int realMaxIdx = -1;
		for (int r = 1; r < L + 1; r++) {
			if (rollcake[r] != 0) {
				cnt[rollcake[r]]++;
				if (realMax < cnt[rollcake[r]]) {
					realMax = cnt[rollcake[r]];
					realMaxIdx = rollcake[r];
				}
			}
		}
		System.out.println(realMaxIdx);
		sc.close();
	}
}