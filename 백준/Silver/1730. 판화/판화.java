import java.util.Scanner;

public class Main {
    public static int n, r, c;
    public static char[][] draw;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        draw = new char[n][n];

        // 모든 배열을 '.'으로 채우기
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                draw[i][j] = (char) 46;
            }

        String commands = "";
        if (sc.hasNext()) commands = sc.next();

        int idx = 0;

        r = 0;
        c = 0;

        int nr, nc;
        int[] currentLoc;

        while (idx < commands.length()) {

            switch (commands.charAt(idx)) {
                case 'U':
                    nr = r - 1;
                    nc = c;
                    currentLoc = fillTheArray(r, c, nr, nc, (char) 124);
                    r = currentLoc[0];
                    c = currentLoc[1];
                    break;
                case 'D':
                    nr = r + 1;
                    nc = c;
                    currentLoc = fillTheArray(r, c, nr, nc, (char) 124);
                    r = currentLoc[0];
                    c = currentLoc[1];
                    break;
                case 'L':
                    nr = r;
                    nc = c - 1;
                    currentLoc = fillTheArray(r, c, nr, nc, (char) 45);
                    r = currentLoc[0];
                    c = currentLoc[1];
                    break;
                case 'R':
                    nr = r;
                    nc = c + 1;
                    currentLoc = fillTheArray(r, c, nr, nc, (char) 45);
                    r = currentLoc[0];
                    c = currentLoc[1];
                    break;
            }
            idx++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(draw[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] fillTheArray(int r, int c, int nr, int nc, char direction) {

        if (nr >= 0 && nc >= 0 && nr < n && nc < n) { // 경계 내부에 있는 경우에만 처리
            //System.out.println("처리 전 r: " + r + "c: " + c + "nr: " + nr + "nc: " + nc);
            change(r, c, direction);
            change(nr, nc, direction);
            r = nr;
            c = nc;
            //System.out.println("처리 후 r: " + r + "c: " + c + "nr: " + nr + "nc: " + nc);

        }

        return new int[]{r, c};
    }

    private static void change(int r, int c, char direction) {

        switch (draw[r][c]) {
            case (char) 46:
                draw[r][c] = direction;
                break;
            case (char) 124:
                if (direction != (char) 124) {
                    draw[r][c] = (char) 43;
                }
                break;
            case (char) 45:
                if (direction != (char) 45) {
                    draw[r][c] = (char) 43;
                }
                break;
        }
    }
}