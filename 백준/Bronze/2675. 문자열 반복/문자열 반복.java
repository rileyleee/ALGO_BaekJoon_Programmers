import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long test = sc.nextInt();
		for (long t = 0; t < test; t++) {
			int iterNum = sc.nextInt();
			String str = sc.next();
			char[] s = str.toCharArray();
			String result = "";

			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < iterNum; j++) {
					result += s[i];
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}