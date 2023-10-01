import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = sc.next().toCharArray();
        }

        int minChanges = Integer.MAX_VALUE;

        for (int i = 0; i <= m - 8; i++) {
            for (int j = 0; j <= n - 8; j++) {
                minChanges = Math.min(minChanges, Math.min(getChanges(board, i, j, 'W'), getChanges(board, i, j, 'B')));
            }
        }

        System.out.println(minChanges);
    }

    public static int getChanges(char[][] board, int startX, int startY, char startColor) {
        int changes = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[startX + i][startY + j] != startColor) {
                    changes++;
                }
                startColor = switchColor(startColor);
            }
            startColor = switchColor(startColor);
        }
        return changes;
    }

    public static char switchColor(char color) {
        return color == 'W' ? 'B' : 'W';
    }
}