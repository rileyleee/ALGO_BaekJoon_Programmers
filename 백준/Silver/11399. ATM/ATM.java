import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int[] time = new int[p];
		for (int t = 0; t < p; t++) {
			time[t] = sc.nextInt();
		}
		Arrays.sort(time);
		int[] timeSum = new int[p];
		timeSum[0] = time[0];
		for (int ts = 1; ts < p; ts++) {
			timeSum[ts] = timeSum[ts - 1] + time[ts];
		}
		int sum = 0;
		for (int i = 0; i < p; i++) {
			sum += timeSum[i];
		}
		System.out.println(sum);
		sc.close();
	}
}