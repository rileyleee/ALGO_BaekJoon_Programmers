import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char s = str.charAt(0);
		int result = s; 
		System.out.println(result);
		sc.close();
	}
}