import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int btn = sc.nextInt();
		int[] bArr = new int[btn + 1];
		for (int b = 1; b <= btn; b++) {
			bArr[b] = sc.nextInt();
		}

		int stNum = sc.nextInt();
		for (int st = 0; st < stNum; st++) {
			int gender = sc.nextInt();
			if (gender == 1) { // 남학생인 경우 부여받은 번호와 그의 배수인 스위치의 상태를 바꾼다.
				int btnNum = sc.nextInt();
				for (int b = 1; b <= btn; b++) {
					if (b % btnNum == 0) {
						bArr[b] = 1 - bArr[b]; // 0이면 1, 1이면 0으로 변경
					}
				}
			} else if (gender == 2) { // 여학생인 경우 부여받은 번호의 양 옆으로 나아가며 대칭의 상태인 경우 각 상태를 바꾼다.
				int btnNum = sc.nextInt();
				bArr[btnNum] = 1 - bArr[btnNum]; // 본인 위치는 무조건 바꾸기
				for (int b = btnNum + 1, i = 1; b <= btn; b++, i++) {
					if (btnNum - i > 0) { // 배열 경계를 넘지 않는다면,
						if (bArr[b] == bArr[btnNum - i]) {
							bArr[b] = 1 - bArr[b];
							bArr[btnNum - i] = 1 - bArr[btnNum - i];
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= btn; i++) {
			cnt++;
			if (cnt > 1 && cnt % 20 == 1) {
				System.out.print("\n");
			}
			System.out.print(bArr[i] + " ");
		}
		sc.close();
	}
}