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

			int i = 0;
			int j = 0;
			int cnt = 0;

			while (i < p && j < t) {
				if (ptArr[i] != textArr[j]) { // 한 인덱스의 값을 보았을 때 다르면 인덱스 조정하고 다음거 보자.
					j -= i;
					i = -1;
				}
				i++;
				j++;
				if (i == p) { // 여러번 돌아서 현재 인덱스와 패턴 인덱스가 동일하면 카운트하고 패턴 인덱스는 0으로 만들어줘 글자는 다음거 봐야지
					cnt++;
					i = 0;
				}
			}
			System.out.println("#" + testNum + " " + cnt);
		}
	}
}