import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int N = sc.nextInt();
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					int temp = str.charAt(j) - 48;
					if (Math.abs(N / 2 - i) + Math.abs(N / 2 - j) <= N / 2) {
						sum += temp;
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}
		sc.close();
	}
}