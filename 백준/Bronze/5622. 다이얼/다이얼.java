import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int l = str.length();

		int[] arr = new int[l];
		for (int s = 0; s < str.length(); s++) {
			arr[s] = str.charAt(s) - 65;
		}
		int sum = 0;
		for (int s = 0; s < arr.length; s++) {
			if (arr[s] >= 0 && arr[s] <= 2) {
				sum += 3;
			} else if (arr[s] >= 3 && arr[s] <= 5) {
				sum += 4;
			} else if (arr[s] >= 6 && arr[s] <= 8) {
				sum += 5;
			} else if (arr[s] >= 9 && arr[s] <= 11) {
				sum += 6;
			} else if (arr[s] >= 12 && arr[s] <= 14) {
				sum += 7;
			} else if (arr[s] >= 15 && arr[s] <= 18) {
				sum += 8;
			} else if (arr[s] >= 19 && arr[s] <= 21) {
				sum += 9;
			} else if (arr[s] >= 22 && arr[s] <= 25) {
				sum += 10;
			}
		}
		System.out.println(sum);
		sc.close();
	}
}