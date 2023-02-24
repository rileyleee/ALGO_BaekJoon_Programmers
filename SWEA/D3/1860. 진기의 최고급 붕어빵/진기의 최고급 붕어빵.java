import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int pNum = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			int fish = Integer.parseInt(st.nextToken());

			int[] secArr = new int[pNum];

			String pStr = br.readLine();
			st = new StringTokenizer(pStr);
			for (int p = 0; p < pNum; p++) {
				secArr[p] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(secArr);
			int max = secArr[pNum - 1];

			// 시기별 만들어지는 붕어빵 수
			int[] sumArr = new int[max + 1];
			int d = 1;

			while (sec * d < sumArr.length) {
				sumArr[sec * d] = fish;
				d++;
			}

			// 누적합 배열
			int[] addArr = new int[sumArr.length];

			addArr[0] = sumArr[0];
			for (int a = 1; a < addArr.length; a++) {
				addArr[a] = sumArr[a] + addArr[a - 1];
			}

			boolean flag = true;
			for (int p = 0; p < pNum; p++) {
				if (addArr[secArr[p]] >= 1) {
					for (int a = secArr[p]; a < addArr.length; a++) {
						addArr[a]--;
					}
				} else if (addArr[secArr[p]] < 1) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println("#" + (t + 1) + " " + "Possible");
			} else {
				System.out.println("#" + (t + 1) + " " + "Impossible");
			}
		}
	}
}