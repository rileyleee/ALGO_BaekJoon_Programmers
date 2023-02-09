import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		List<Double> scores = new ArrayList<>();

		for (int i = 0; i < test; i++) {
			scores.add(sc.nextDouble());
		}

		double max = scores.get(0);
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i) > max)
				max = scores.get(i);
		}

		double sum = 0;
		for (int i = 0; i < scores.size(); i++) {
			double temp = scores.get(i);
			temp = temp / max * 100;
			scores.set(i, temp);
			sum += scores.get(i);
		}
		System.out.println(sum / scores.size());
		sc.close();
	}
}