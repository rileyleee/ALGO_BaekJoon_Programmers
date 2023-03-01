import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt(); // 사람수
		int m = sc.nextInt(); // 게임종료 조건
		int l = sc.nextInt(); // + 또는 - 하는 정도

		int[] cnt = new int[p];
		// 사람이 0번부터 시작한다고 가정
		// 공을 받는 카운트 어느 하나라도 M이 되면 게임 종료
		// 공을 받을 때 마다 +1 된다.
		int s = 0;
		int ball = 0;
		cnt[0] = 1; // 처음에 공을 받는 0번
		outer: while (true) {
			for (int c = 0; c < cnt.length; c++) {
				if (cnt[c] >= m) {
					break outer;
				}
			}
			if (cnt[s] % 2 == 1) {
				s = (s + l) % p;
				cnt[s]++;
				ball++;
			} else if (cnt[s] % 2 == 0) {
				s = (s - l) % p;
				if (s < 0) {
					s += p;
				}
				cnt[s]++;
				ball++;
			}
		}
		System.out.println(ball);
	}
}