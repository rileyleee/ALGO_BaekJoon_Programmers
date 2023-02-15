import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		str = str.toUpperCase(); // 받은 문자열을 대문자로
		char[] chara = str.toCharArray(); // 문자열을 문자 배열로
		int[] chaInt = new int[26]; // 알파벳 수 길이의 정수 배열 생성
        
		for (int i = 0; i < chara.length; i++) {
			chaInt[(int) chara[i] - 65] += 1; // 알파벳 -> 정수(아스키: A =0) 인덱스 역할
		}

		long max = -1;
		int idx = 0;
		for (int i = 0; i < chaInt.length; i++) {
			if (max < chaInt[i]) {
				max = chaInt[i];
				idx = i;
			}
		}

		long cnt = 0;
		for (int i = 0; i < chaInt.length; i++) {
			if (max == chaInt[i]) {
				cnt++;
			}
		}

		if (cnt >= 2) {
			System.out.println("?");
		} else {
			char result = (char) (idx + 65); // 먼저 값을 더해요!!! 0 = 48 A=65 a=97
			System.out.println(result);
		}
		sc.close();
	}
}