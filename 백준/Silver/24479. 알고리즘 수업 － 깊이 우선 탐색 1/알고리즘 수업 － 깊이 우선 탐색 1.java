import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int idx = 0;
    public static int[] order;
    public static ArrayList[] list;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        order = new int[n + 1];
        visited = new boolean[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);

        }

        br.close();

        for (int i = 0; i <= n; i++) {
            Collections.sort(list[i]);
        }


        dfs(r);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= n; i++) {
            bw.write(order[i] + "\n");
        }

        bw.flush();
    }

    private static void dfs(int r) {
        ++idx;
        visited[r] = true;
        order[r] = idx;
        //System.out.println("r: "+r);
        //System.out.println("idx: "+idx);

        for (int i = 0; i < list[r].size(); i++) {
            if (!visited[(int) list[r].get(i)]) {
                //System.out.println("여기로떠남: "+ list[r].get(i).toString());
                dfs((int) list[r].get(i));

            }
        }
    }
}