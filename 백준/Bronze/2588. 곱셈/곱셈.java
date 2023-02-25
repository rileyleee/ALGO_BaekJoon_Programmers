import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		String B = sc.next();

		String b1 = B.substring(2);
		String b2 = B.substring(1, 2);
		String b3 = B.substring(0, 1);

		int ib1 = Integer.parseInt(b1);
		int ib2 = Integer.parseInt(b2);
		int ib3 = Integer.parseInt(b3);

		int r1 = A * ib1;
		int r2 = A * ib2;
		int r3 = A * ib3;

		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r1 + r2 * 10 + r3 * 100);

		sc.close();
	}

}
