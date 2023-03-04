import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		int r = sc.nextInt();

		int cut = sc.nextInt();

		int[] rowCut = new int[cut + 1];
		int[] colCut = new int[cut + 1];

		for (int t = 0; t < cut; t++) {

			int dir = sc.nextInt();
			int line = sc.nextInt();

			switch (dir) {
			case 0:
				rowCut[t] = line;
				break;
			case 1:
				colCut[t] = line;
				break;
			}
		}
		rowCut[cut] = r;
		colCut[cut] = c;
		Arrays.sort(rowCut);
		Arrays.sort(colCut);
		int rMax = Integer.MIN_VALUE;
		int cMax = Integer.MIN_VALUE;
		for (int i = cut; i > 0; i--) {
			rMax = Math.max(rMax, rowCut[i] - rowCut[i - 1]);
			cMax = Math.max(cMax, colCut[i] - colCut[i - 1]);
		}
		System.out.println(rMax * cMax);
		sc.close();
	}
}