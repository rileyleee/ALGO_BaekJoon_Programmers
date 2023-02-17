import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.next().toCharArray();

		int[] iArr = new int[arr.length];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = (int) arr[i];
		}

		int initial = iArr[0]; // 배열 첫 값 초기화
		int tmp = iArr[0]; // 값 변경 시 저장할 변수
		int cnt = 0; // 뒤집기 횟수 저장

		for (int i = 0; i < iArr.length; i++) {
			if (initial != iArr[i]) { // 초기값과 다르고
				if (tmp != iArr[i]) { // 최근값과 다르면
					cnt++; // 뒤집고
					tmp = iArr[i]; // 새로 최근값 저장
				}
			}
			if (initial == iArr[i]) { // 초기값과 같지만
				if (tmp != iArr[i]) { // 최근값과는 다르다면
					tmp = iArr[i]; // 최근 값만 새로 저장 (비교를 위해 저장하고 뒤집지는 않는다)
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}