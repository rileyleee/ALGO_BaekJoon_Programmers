import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int stu = sc.nextInt();
		int[] order = new int[stu];

		int cnt = 0;
		for (int n = 0; n < stu; n++) {
			cnt++;
			int num = sc.nextInt();
			int target = order.length - 1 - num;
			if (order[target] == 0) {
				order[target] = cnt;
			} else {
				for (int re = 0; re < target; re++) {
					order[re] = order[re + 1];
				}
				order[target] = cnt;
			}
		}
		for (int n = 0; n < stu; n++) {
			System.out.print(order[n] + " ");
		}
		sc.close();
	}
}