import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		String [] str2 = str.split(" ");		
		
		int sNum = Integer.parseInt(str2[0]);
		int lowS = Integer.parseInt(str2[1]);

		String[] scores = new String[sNum];
		int[] scoreInt = new int[sNum];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			scores[idx] = st.nextToken();
			idx++;
		}

		for (int i = 0; i < scores.length; i++) {
			scoreInt[i] = Integer.parseInt(scores[i]);
		}
		for (int i = 0; i < scoreInt.length - 1; i++) {
			for (int j = 0; j < scoreInt.length - 1; j++) {
				if (scoreInt[j] < scoreInt[j + 1]) {
					int temp = scoreInt[j];
					scoreInt[j] = scoreInt[j + 1];
					scoreInt[j + 1] = temp;
				}
			}
		}
		System.out.println(scoreInt[lowS - 1]);
	}
}