import java.util.Scanner;

public class Main {
	static int n, cnt; // (n,n)에 도착하는 경우의 수
	static int[][] house;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 0;
		int c = 0;
		n = sc.nextInt();
		house = new int[n + 2][n + 2];
		// 빈칸은 0 벽은 1
		for (r = 1; r < n + 1; r++) { // 집 상태 채우기
			for (c = 1; c < n + 1; c++) {
				house[r][c] = sc.nextInt();
			}
		}
		// 처음 파이프 위치
		r = 1;
		c = 2;

		// 방향 변수 설정 가로 0 세로 1 대각선 2; 초기값이 가로임
		int d = 0;

		pipe(r, c, d);
		System.out.println(cnt);
		sc.close();

	}

	private static void pipe(int r, int c, int d) {
		// 1) 경계를 벗어나지 않는지 / 가려는 위치가 벽은 아닌지(1)
		// 2) 방향이 0인 경우 -> 0, 2만 가능 / 1인 경우 -> 0,2만 가능 / 2인 경우 0, 1, 2 모두 가능
		// 3) (r,c)가 (n,n)인 경우 cnt 증가
		// 4) 대각선으로 놓이는 경우 3칸을 사용하게 됨

		// 기저조건
		if (r > n || c > n) { // 경계 넘으면 호출한 함수로 돌아가기
			return;
		}

		if (r == n && c == n) {
			cnt++;
			// System.out.println("cnt: " + cnt);
			return;
		}

		// 유도조건

		// 기존이 가로 방향이고 가로로 가는 경우
		if (d == 0 && house[r][c + 1] != 1 && c + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r, c + 1, 0); // 새 출발점
		}
		// 기존이 가로 방향이고 대각선으로 가는 경우
		if (d == 0 && house[r][c + 1] != 1 && house[r + 1][c] != 1 && house[r + 1][c + 1] != 1 && r + 1 <= n
				&& c + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r + 1, c + 1, 2); // 새 출발점
		}

		// 기존이 세로 방향이고 세로로 가는 경우
		if (d == 1 && house[r + 1][c] != 1 && r + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r + 1, c, 1);
		}
		// 기존이 세로 방향이고 대각선으로 가는 경우
		if (d == 1 && house[r][c + 1] != 1 && house[r + 1][c] != 1 && house[r + 1][c + 1] != 1 && r + 1 <= n
				&& c + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r + 1, c + 1, 2);
		}

		// 기존이 대각선 방향이고 가로로 가는 경우
		if (d == 2 && house[r][c + 1] != 1 && c + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r, c + 1, 0); // 새 출발점
		}
		// 기존이 대각선 방향이고 세로로 가는 경우
		if (d == 2 && house[r + 1][c] != 1 && r + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r + 1, c, 1);
		}
		// 기존이 대각선 방향이고 대각선으로 가는 경우
		if (d == 2 && house[r][c + 1] != 1 && house[r + 1][c] != 1 && house[r + 1][c + 1] != 1 && r + 1 <= n
				&& c + 1 <= n) {
			// System.out.printf("r: %d c: %d d: %d \n", r, c, d);
			pipe(r + 1, c + 1, 2);
		}
	}
}