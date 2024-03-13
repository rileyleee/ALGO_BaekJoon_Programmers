import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] wires = new int[k];

        int max = -1;

        while (--k >= 0) {
            wires[k] = Integer.parseInt(br.readLine());
            max = Math.max(max, wires[k]);
        }

        Arrays.sort(wires);

        long l = 1;
        long r = Integer.MAX_VALUE;

        long len = -1;


        while (l <= r) {
            long m = (l + r) / 2;

            int tmp = 0;

            for (int i = 0; i < wires.length; i++) {
                tmp += (wires[i] / m);
            }

            if (tmp >= n) {
                l = m + 1;
                len = m;
            } else {
                r = m - 1;
            }
        }

        System.out.println(len);
    }
}