import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 0은 빈칸, 1은 벽, 2는 바이러스
    // 바이러스는 상하좌우로 이동 => bfs
    // 세워야 하는 벽의 개수 3 => dfs
    // 안전영역 최댓값 구하기

    static int n, m;
    static int[][] arr;

    static int safeZone = Integer.MIN_VALUE;

    public static class virus {
        int x;
        int y;

        public virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfsForWall(0);

        System.out.println(safeZone);

    }

    private static void dfsForWall(int wall) { // 벽 세우기

        if (wall == 3) {
            bfsForVirus(); // 매번 바이러스 확산시키고 안전영역 확인
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) { // 빈 칸 이면
                    arr[i][j] = 1; //벽세우기
                    dfsForWall(wall + 1);
                    arr[i][j] = 0; // 원상복구
                }
            }
        }
    }

    private static void bfsForVirus() { // 바이러스 퍼뜨리기

        int[][] virusArr = new int[n][m];

        Queue<virus> qu = new LinkedList<>();

//        for (int i = 0; i < n; i++) { // 깊은 복사 => 기존 배열 바꾸지 않기 위함
//            for (int j = 0; j < m; j++) {
//                virusArr[i][j] = arr[i][j];
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, virusArr[i], 0, virusArr[i].length);
        }
        // 참고
        // 1차원 배열의 경우 배열.clone()으로 깊은 복사 가능
        // 2차원 배열의 경우 이중 반복문 또는 System.arraycopy()를 활용하여 깊은 복사
        // 2차원 배열에서 배열.clone()을 사용할 경우 얕은 복사가 됨
        // 객체 배열의 경우 배열.clone() 또는 System.arraycopy()를 사용할 경우 깊은 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusArr[i][j] == 2) {
                    qu.offer(new virus(i, j));
                }
            }
        }

        int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!qu.isEmpty()) {

            virus thisV = qu.remove();

            for (int i = 0; i < drc.length; i++) { // 상하좌우 바이러스 퍼뜨리기

                int nr = thisV.x + drc[i][0];
                int nc = thisV.y + drc[i][1];

                if (nc < 0 || nr < 0 || nr >= n || nc >= m) continue; // 경계 넘으면 지나가고

                if (virusArr[nr][nc] == 0) {
                    virusArr[nr][nc] = 2; // 바이러스 퍼뜨리고
                    qu.add(new virus(nr, nc)); // 또 확산될 대상으로 넣기
                }
            }
        }
        // 바이러스 확산시킨 다음 안전 구역 세기
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (virusArr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        safeZone = Math.max(safeZone, cnt);
    }
}