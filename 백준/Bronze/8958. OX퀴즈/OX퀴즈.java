import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < test; t++) {
			
			String s = br.readLine();
			String[] arr;
			arr = s.split("");

			int score = 0;
			int cnt = 1;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("O")) {
					score = score + cnt;
					if (i == (arr.length - 1)) {
						break;
					} else if (arr[i].equals(arr[i + 1])) {
						cnt++;
					} else {
						cnt = 1;
					}
				}
			}
			System.out.println(score);
		}
	}
}