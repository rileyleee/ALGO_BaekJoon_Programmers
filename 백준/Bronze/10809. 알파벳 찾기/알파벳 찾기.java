import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] string = sc.next().toCharArray();
		int[] alphaArr = new int[string.length];
		for (int i = 0; i < string.length; i++) {
			alphaArr[i] = (int) string[i] - 97;
		}
		int[] alpha = new int[26];
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = -1;
		}
		for (int i = 0; i < alphaArr.length; i++) {
			if (alpha[alphaArr[i]] == -1)
				alpha[alphaArr[i]] = i;
		}
		// 배열 출력
		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i] + " ");
		}
		sc.close();
	}
}