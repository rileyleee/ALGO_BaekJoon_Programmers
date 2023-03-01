import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cNum = sc.nextInt();
		int target = sc.nextInt();

		int[] cArr = new int[cNum];

		for (int c = 0; c < cNum; c++) {
			cArr[c] = sc.nextInt();
		}
		int bj = 0;	int i = -1;	int j = -1;	int k = -1;	int max = 0;

		outer: for (int c = 0; c < cNum - 2; c++) {
			i = cArr[c];
			for (int d = c + 1; d < cNum - 1; d++) {
				j = cArr[d];
				for (int e = d + 1; e < cNum; e++) {
					k = cArr[e];
					if (i + j + k < target) {
						bj = i + j + k;
						if (bj > max) {
							max = bj;
						}
					} else if (i + j + k == target) {
						max = target;
						continue outer;
					}
				}
			}
		}
		if (max != 0) {
			System.out.println(max);
		}
	}
}