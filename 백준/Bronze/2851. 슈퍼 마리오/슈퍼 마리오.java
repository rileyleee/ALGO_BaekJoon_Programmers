import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] mushAdd = new int[10];

		mushAdd[0] = sc.nextInt();
		for (int m = 1; m < 10; m++) {
			mushAdd[m] = mushAdd[m - 1] + sc.nextInt();
		}
		int diff = 100;
		int result = 0;
		for (int m = 0; m < 10; m++) {
			if (Math.abs(mushAdd[m] - 100) <= diff) {
				diff = Math.abs(mushAdd[m] - 100);
				result = mushAdd[m];
			}
		}
		System.out.println(result);
		sc.close();
	}
}