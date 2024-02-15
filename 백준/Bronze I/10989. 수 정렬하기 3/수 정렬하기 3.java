import java.io.*;

public class Main {
    public static int n, max;
    public static int[] cntArr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        cntArr = new int[10000+1];

        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int thisNum = Integer.parseInt(br.readLine());

            max = Math.max(max, thisNum);

            cntArr[thisNum]++;
        }
        br.close();
    }

    private static void solve() throws IOException {

        // System.out.println(Arrays.toString(cntArr));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i <= max; i++) {
            if (cntArr[i] != 0) {
                for (int j = 0; j < cntArr[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}