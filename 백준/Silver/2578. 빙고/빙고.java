import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 보드 생성 후 입력
		int[][] board = new int[5][5];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		// 숫자 부른 횟수 카운트
		int cnt = 0;
		int Bingo = 0;
		// 총 25번 숫자를 부를 수 있음 -> 그 횟수만큼 반복
		while (cnt < 25) {
			// 부르는 숫자 저장
			int turn = sc.nextInt();
			// 부를 때 마다 몇번째인지 카운트하고
			cnt++;
			// 해당되는 좌표값 저장하기
			int cR = -1;
			int cC = -1;
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (turn == board[r][c]) {
						cR = r;
						cC = c;
						// 일치한 숫자는 100으로 변경
						board[r][c] = 100;
						break; // for문 빠져나가기
					}
				}
			}
			// 가로와 세로 합 구하기
			int rSum = 0; // 가로
			int cSum = 0; // 세로
			for (int c = 0; c < 5; c++) {
				rSum += board[cR][c];
			}
			for (int r = 0; r < 5; r++) {
				cSum += board[r][cC];
			}

			// 대각선 합 구하기
			int dlSum = 0; // 좌하향
			int drSum = 0; // 우하향

			// 우하향 대각선
			if (cR == cC) {
				for (int d = 0; d < 5; d++) {
					drSum += board[d][d];
				}
			}
			// 좌하향 대각선
			if (cR + cC == 4) {
				for (int d = 0; d < 5; d++) {
					dlSum += board[d][Math.abs(d - 4)];
				}
			}
			if (rSum == 500) {
				Bingo++;
			}
			if (cSum == 500) {
				Bingo++;
			}
			if (dlSum == 500) {
				Bingo++;
			}
			if (drSum == 500) {
				Bingo++;
			}
			if (Bingo >= 3) {
				break;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}