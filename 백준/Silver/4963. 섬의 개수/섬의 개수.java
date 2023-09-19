import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			cnt = 0;

			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w == 0 && h == 0) { // 테케 종료를 알리는 입력값
				break;
			}

			map = new int[h + 2][w + 2];
			visited = new boolean[h + 2][w + 2];

			for (int r = 1; r <= h; r++) {
				for (int c = 1; c <= w; c++) {
					map[r][c] = sc.nextInt(); // 1은 땅 0은 바다
				}
			}

			for (int r = 1; r <= h; r++) {
				for (int c = 1; c <= w; c++) {
					if (!visited[r][c] && map[r][c] == 1) {
						visited[r][c] = true;
						cnt++;
						DFS(r, c);
					}
				}
			}
			System.out.println(cnt);
		}

		sc.close();

	}

	private static void DFS(int r, int c) {
		// 8방탐색(r과 c) //상,우상,우,우하,하좌,하,좌,좌상
		int[][] drc = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { 1, 0 }, { 0, -1 }, { -1, -1 } };

		for (int d = 0; d < drc.length; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];

			if (!visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				DFS(nr, nc);
			}
		}
	}
}