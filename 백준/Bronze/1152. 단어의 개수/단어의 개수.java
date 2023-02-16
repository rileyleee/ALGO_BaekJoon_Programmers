import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine(); // 공백이 존재할 경우는 nextLine으로 받기
		StringTokenizer st = new StringTokenizer(str, " "); 
        // 공백을 기준으로 str을 구분하고 st에 담기.

		List<String> words = new ArrayList<>();

		while (st.hasMoreTokens()) {
			words.add(st.nextToken());
		}

		System.out.println(words.size());

		sc.close();
	}
}