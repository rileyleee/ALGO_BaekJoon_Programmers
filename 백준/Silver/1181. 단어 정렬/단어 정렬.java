import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	// 단어의 개수가 최대 20,000개 이기 때문에 2중 반복문 사용하면 4억개로 4초가 소요됨 -> 시간 초과
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int wNum = Integer.parseInt(br.readLine());
		String[] words = new String[wNum];
		for (int i = 0; i < wNum; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 단어 길이가 같을 경우
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2); // 사전 순 정렬
				}
				// 그 외의 경우
				else {
					return s1.length() - s2.length();
				}
			}
		});

		System.out.println(words[0]);
		for (int i = 1; i < words.length; i++) {
			// 중복되지 않는 단어만 출력
			if (!words[i].equals(words[i - 1])) {
				System.out.println(words[i]);
			}
		}
	}
}