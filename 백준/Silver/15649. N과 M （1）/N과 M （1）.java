import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] make;
	static StringBuilder sb;
	static int[] already;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		make = new int[m + 1];
		already = new int[n + 1];

		sb = new StringBuilder();

		rec(1);
		System.out.println(sb.toString());

		sc.close();
	}

	private static void rec(int i) {
		// 기저조건
		if (i == m + 1) {
			for (int a = 1; a < make.length; a++) {
				sb.append(make[a]).append(" ");
			}
			sb.append("\n");
		}

		// 재귀조건
		else {
			for (int num = 1; num <= n; num++) {
				if (already[num] == 0) {
					make[i] = num;
					already[num] = 1;
				} else {
					continue;
				}
				rec(i + 1);
				make[i] = 0;
				already[num] = 0;
			}
		}
	}
}