import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {

			// 1개의 테스트 케이스
			String[] str = br.readLine().split(" "); // 버퍼드리더는 줄 단위로 읽기 때문에 잘라줘야 함

			int student = Integer.parseInt(str[0]);

			List<Integer> scores = new ArrayList<>();

			// 학생별 점수 arr에 담기
			for (int i = 1; i < str.length; i++) {
				scores.add(Integer.parseInt(str[i]));
			}
			// 평균 구하기
			int sum = 0;
			for (int score : scores) {
				sum += score;
			}
			int avg = sum / student;
			double cnt = 0;
			for (int score : scores) {
				if (score > avg) {
					cnt++;
				}
			}

			double ratio = cnt / student * 100;

			System.out.printf("%.3f", ratio);
			System.out.println("%");
		}
	}
}