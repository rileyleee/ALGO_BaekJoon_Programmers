import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			String str = br.readLine();
			if (str.equals("0")) {
				flag = false;
			} else {
				char[] strArr = new char[str.length()];
				for (int i = 0; i < str.length(); i++) {
					strArr[i] = str.charAt(i);
				}
				boolean pal = true;
				for (int i = 0; i < strArr.length / 2; i++) {
					if (strArr[i] == strArr[strArr.length - i - 1]) {
						pal = true;
					} else {
						pal = false;
						break;
					}
				}
				if (pal)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}
}