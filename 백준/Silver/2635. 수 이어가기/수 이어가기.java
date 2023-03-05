import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);

		int firstLetter = sc.nextInt();
		int first = firstLetter;
		int second = 0; int next = 0; int cnt = 0; 
        int max = Integer.MIN_VALUE; int nomi = 0;

		for (int i = firstLetter; i >= 1; i--) { // 두번째 수 고르기
			cnt = 2;
			first = firstLetter;
			second = i;
			while (true) {
				next = first - second;
				cnt++;
				if (next < 0) {
					cnt--;
					break;
				} else {
					first = second;
					second = next;
				}
			}
			if (cnt > max) {
				max = cnt;
				nomi = i;
			}
		}
		System.out.println(max);
		System.out.print(firstLetter + " " + nomi);
		first = firstLetter;
		while (true) {
			next = first - nomi;
			if (next < 0) {
				break;
			} else {
				first = nomi;
				nomi = next;
				System.out.print(" " + next);
			}
		}
		sc.close();
	}
}