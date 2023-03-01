import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = sc.nextInt();
		int five = total / 5; // 5 킬로그램짜리 봉지를 가장 많이 가져갈 때 봉지 수
		int remain_five = total - (5 * five); // 가져가고 난 후 남는 킬로그램 수
		int three = 0;

		if (total == 4 || total == 7) {
			five = -1;
		} else if (total == 3) {
			three = 1;
		} else if (total >= 5) {
			if (remain_five == 0) {
				three = 0;
			} else if (remain_five == 1) {
				five = five - 1;
				three = 2;
			} else if (remain_five == 2) { // total이 7인 경우 오류
				five = five - 2;
				three = 4;
			} else if (remain_five == 3) {
				three = 1;
			} else if (remain_five == 4) {
				five = five - 1;
				three = 3;
			}
		}
		System.out.println(five + three);
		sc.close();
	}
}