import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int setNum = sc.nextInt();
		int testNum = sc.nextInt();

		HashSet<String> set = new HashSet<>();

		for (int s = 0; s < setNum; s++) {
			set.add(sc.next());
		}

		int count = 0;

		for (int t = 0; t < testNum; t++) {
			if (set.contains(sc.next())) {
				count++;
			}
		}

		System.out.println(count);
		sc.close();
	}
}