import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        char[][] words = new char[n][m];
        int[][] freq = new int[m][4];

        for (int i = 0; i < n; i++) {
            String nextStr = sc.next();
            for (int j = 0; j < m; j++) {
                words[i][j] = nextStr.charAt(j);

                switch (words[i][j]) {
                    case 'A':
                        freq[j][0]++;
                        break;
                    case 'C':
                        freq[j][1]++;
                        break;
                    case 'G':
                        freq[j][2]++;
                        break;
                    case 'T':
                        freq[j][3]++;
                        break;
                }

            }
        }

        StringBuilder sb = new StringBuilder();


        // 자료 입력 확인
//        for (int i = 0; i<m; i++){
//            System.out.println(Arrays.toString(freq[i]));
//        }

        int hd = 0;
        for (int i = 0; i < m; i++) {
            int max = -1;
            int idx = -1;
            for (int j = 0; j < 4; j++) {
                if (freq[i][j] > max) {
                    max = freq[i][j];
                    idx = j;
                }
            }
            hd+=(n-max);
            switch (idx) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
            }
        }

        System.out.print(sb.toString()+"\n"+hd);

    }
}