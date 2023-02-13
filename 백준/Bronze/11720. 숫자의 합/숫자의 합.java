import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		String str = sc.next();
		int[] numArr = new int[nums];
		for (int i = 0; i < nums; i++) {
			numArr[i] = str.charAt(i) - 48;
		}
		long sum = 0;
		for (int digit : numArr) {
			sum += digit;
		}
		System.out.println(sum);
		sc.close();
	}
}