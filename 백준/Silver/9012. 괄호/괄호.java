import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		Stack<Character> stk = new Stack<>();
		outer: for (int t = 0; t < test; t++) {
			stk.clear();

			String str = br.readLine();
			char[] arr = str.toCharArray();

			for (char c : arr) {
				if (c == '(') {
					stk.push(c);
				} else if (c == ')') {
					if (!stk.isEmpty()) {
						stk.pop();
					} else {
						System.out.println("NO");
						continue outer;
					}
				}
			}
			if (!stk.isEmpty()) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}