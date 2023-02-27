import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 0; t < test; t++) {

			String memory = sc.next();
			int[] mArr = new int[memory.length()];

			// 원래 메모리 배열에 담기
			for (int m = 0; m < memory.length(); m++) {
				mArr[m] = memory.charAt(m) - 48;
			}
			// 초기값 배열 만들기
			int[] nullArr = new int[mArr.length];

			int cnt = 0;
			for (int c = 0; c < mArr.length; c++) {
				if (mArr[c] != nullArr[c]) {
					int ans = mArr[c];
					for (int s = c; s < mArr.length; s++) {
						nullArr[s] = ans;
					}
					cnt++;
				}
			}
			System.out.println("#" + (t + 1) + " " + cnt);
		}
		sc.close();
	}
}