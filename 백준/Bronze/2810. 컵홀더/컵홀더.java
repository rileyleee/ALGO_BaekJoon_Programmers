import java.util.Scanner;

public class Main {
	public static void main(String[] args) { // 맨 왼쪽 컵홀더는 나중에 +1 // S는 모두, L 두번째에만 세기
		Scanner sc = new Scanner(System.in);

		int sNum = sc.nextInt();
		int cnt = 0;
		int couple = 0;
		char[] sArr = sc.next().toCharArray();

		for (int s = 0; s < sNum; s++) {
			if (sArr[s] == 'S') {
				cnt++;
			} else {
				couple++;
				if (couple == 2) {
					cnt++;
					couple = 0;
				}
			}
		}
		System.out.println(Math.min(cnt + 1, sNum));
		sc.close();
	}
}