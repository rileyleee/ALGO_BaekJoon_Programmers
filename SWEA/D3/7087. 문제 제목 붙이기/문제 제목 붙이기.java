import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		for (int t = 1; t <= test; t++) {
			int wNum = sc.nextInt();
			int[] list = new int[wNum];
			int max = 0;
			for (int w = 0; w < wNum; w++) {
				list[w] = sc.next().charAt(0) - 65;
				max = Math.max(list[w], max);
			}
			Arrays.sort(list);
			int[] cntArr = new int[max + 1];

			for (int w = 0; w < wNum; w++) {
				cntArr[list[w]] = 1;
			}
			int cnt = 0;
			for (int c = 0; c < cntArr.length; c++) {
				if (cntArr[c] == 1) {
					cnt++;
				} else {
					break;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
}