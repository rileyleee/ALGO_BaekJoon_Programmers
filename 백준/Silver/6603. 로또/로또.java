import java.util.*;
import java.io.*;

public class Main {
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static StringTokenizer st;
    public static int[] ans, candi;
    public static int k;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            candi = new int[k];
            for (int i = 0; i < k; i++) candi[i] = Integer.parseInt(st.nextToken());

            //System.out.println(Arrays.toString(candi));

            ans = new int[6];

            choose(0);
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void choose(int curr) throws IOException {

        if (curr == 6) {
            //System.out.println(Arrays.toString(ans));
            for (int i : ans) bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for (int i = 0; i < k; i++) {

            if (curr != 0 && ans[curr - 1] >= candi[i]) continue;

            ans[curr] = candi[i];

            choose(curr + 1);


        }

    }
}