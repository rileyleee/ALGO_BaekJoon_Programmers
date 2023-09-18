import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;

    static public class now {
        int r;
        int c;

        public now(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        maze = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String temp = sc.next();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = temp.charAt(j - 1) - 48;
            }
        }

        BFS(1, 1);

    }

    private static void BFS(int r, int c) {

        Queue<now> qu = new LinkedList<>();
        qu.offer(new now(r, c));
        visited[r][c] = true;

        int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        outer:
        while (!qu.isEmpty()) {
            now curr = qu.poll();

            for (int i = 0; i < drc.length; i++) {
                int nr = curr.r + drc[i][0];
                int nc = curr.c + drc[i][1];

                if (nr == n && nc == m) {
                    System.out.println(maze[curr.r][curr.c] + 1);
                    break outer;
                }

                if (nr < 1 || nc < 1 || nr > n || nc > m|| visited[nr][nc]) {
                    continue;
                }

                if (!visited[nr][nc] && maze[nr][nc] == 1) {
                    qu.offer(new now(nr, nc));
                    maze[nr][nc] = maze[curr.r][curr.c] + 1;
                    visited[nr][nc] = true;
                }
            }
        }
    }
}