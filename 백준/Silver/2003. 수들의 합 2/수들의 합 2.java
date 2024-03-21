import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] acc = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(arr));

        acc[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            acc[i] = acc[i - 1] + arr[i];
        }
        //System.out.println(Arrays.toString(acc));

        int cnt = 0;

        int l = 1;
        int r = 1;

        while (l <= n && r <= n) {
            //System.out.printf("l은 %d, r은 %d", l, r);
            //System.out.println();
            if (acc[r] - acc[l - 1] == m) {
                r++;
                cnt++;
                //System.out.println("더해졌어요");
            } else if (acc[r] - acc[l - 1] > m) l++;
            else r++;
        }

        System.out.println(cnt);


    }
}