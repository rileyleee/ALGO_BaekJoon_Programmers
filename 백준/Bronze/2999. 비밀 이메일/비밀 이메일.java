import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 암호화된 메세지 문자열로 받기
		String code = sc.next();
		// 문자열의 길이 저장하기
		int l = code.length();
		// 행(R)렬(C) 찾기 위해 약수 찾기 (N =S*C) N의 최대 길이: 100
		int cnt = 0; // 약수의 개수 찾기
		for (int i = 1; i <= l; i++) {
			if (l % i == 0) {
				cnt++;
			}
		}
		// 약수를 배열에 담고 기준이 될 행렬 가져오기
		int[] divArr = new int[cnt];
		int d = 0;
		for (int i = 1; i <= l; i++) {
			if (l % i == 0) {
				divArr[d] = i;
				d++;
			}
		}
		int R = -1;
		int C = -1;		
		if (divArr.length % 2 == 0) { // 약수의 수가 짝수일 때
			R = divArr[(divArr.length - 1) / 2];
			C = divArr[(divArr.length - 1) / 2 + 1];		
		} else { // 약수의 수가 홀수일 때
			R = divArr[(divArr.length - 1) / 2];
			C = divArr[(divArr.length - 1) / 2];
		}
		char[][] decode = new char[R][C];
		int o = 0;		
		for (int c = 0; c < C; c++) { // 열 우선순위로 암호화된 메세지 작성
			for (int r = 0; r < R; r++) {
				decode[r][c] = code.charAt(o);
				o++;
			}
		}		
		for (int r = 0; r < R; r++) { // 행 우선순위로 읽기
			for (int c = 0; c < C; c++) {
				System.out.print(decode[r][c]);
			}
		}
		sc.close();
	}
}