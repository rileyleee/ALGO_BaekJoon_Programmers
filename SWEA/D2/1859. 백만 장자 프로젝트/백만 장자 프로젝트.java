import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int[] price = new int[n];
			int max = Integer.MIN_VALUE;
			long profit = 0;
			for (int p = 0; p < n; p++) {
				price[p] = sc.nextInt();
			}
			for (int p = n-1; p >= 0; p--) {
				if (max < price[p]) {
					max = price[p];
				} else {
					profit += max - price[p];
				}
			}
			System.out.println("#" + t + " " + profit);
		}
		sc.close();
	}
}