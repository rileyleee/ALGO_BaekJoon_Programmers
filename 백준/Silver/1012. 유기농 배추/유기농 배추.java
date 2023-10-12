import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static public class position {
        int r;
        int c;

        public position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {

            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] agri = new int[m][n];
            boolean[][] visited = new boolean[m][n];

            int cabb = sc.nextInt();

            while (cabb > 0) {

                int x = sc.nextInt();
                int y = sc.nextInt();

                agri[x][y] = 1;

                cabb--;
            }

            Queue<position> qu = new LinkedList<>();

            int snake = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && agri[i][j] == 1) {
                        qu.add(new position(i, j));
                        visited[i][j] = true;
                        snake++;

                        int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

                        while (!qu.isEmpty()) {
                            position curr = qu.poll();

                            for (int d = 0; d < drc.length; d++) {
                                int nr = curr.r + drc[d][0];
                                int nc = curr.c + drc[d][1];

                                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc] || agri[nr][nc] == 0)
                                    continue;

                                qu.add(new position(nr, nc));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(snake);
        }
    }
}