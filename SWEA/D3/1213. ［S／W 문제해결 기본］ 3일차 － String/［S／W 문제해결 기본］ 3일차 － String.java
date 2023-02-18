import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 0; test < 10; test++) {
			int testNum = Integer.parseInt(br.readLine());
			String pt = br.readLine();
			String text = br.readLine();

			char[] ptArr = pt.toCharArray();
			char[] textArr = text.toCharArray();
			int p = ptArr.length;
			int t = textArr.length;
			int cnt = 0;

			for (int j = 0; j < t - p + 1; j++) {
				boolean flag = true;
				for (int i = 0; i < p; i++) {
					if (ptArr[i] != textArr[j + i]) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}
			System.out.println("#" + testNum + " " + cnt);
		}
	}
}