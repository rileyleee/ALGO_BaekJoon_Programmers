import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 최솟값이 되려면! 마이너스 뒤는 무조건 크게 만들어야 한다 -> 마이너스를 기준으로 자르자
		String str = sc.next();
		String[] minusSplit = str.split("-");

		int result = 0;
		for (int m = 0; m < minusSplit.length; m++) {
			int sum = 0;
			String[] plusSplit = minusSplit[m].split("\\+");// 플러스 기준으로 자르기
			for (int p = 0; p < plusSplit.length; p++) {
				sum += Integer.parseInt(plusSplit[p]);
			}

			if (m == 0) { // 처음 뭉텅이 값은 더해줘야 한다.
				result += sum;
			} else {
				result -= sum; // 큰 수를 빼 주어야 최솟값이 됨
			}
		}
		System.out.println(result);
		sc.close();
	}
}