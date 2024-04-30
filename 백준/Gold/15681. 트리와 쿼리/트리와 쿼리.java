import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int n, r, q;
    public static ArrayList[] tree;
    public static boolean[] visited;
    public static int[] ans;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        ans = new int[n + 1];

        for (int i = 0; i <= n; i++) tree[i] = new ArrayList<Integer>();

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v); // 가중치와 방향성이 없기 때문에 양방향으로!
            tree[v].add(u);
        }

        findDepth(r);

        for (int i = 0; i < q; i++) {
            int target = sc.nextInt();
            bw.write(ans[target] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void findDepth(int node) {

        visited[node] = true;
        ans[node] = 1;

        for (int i = 0; i < tree[node].size(); i++) {
            int now = (int) tree[node].get(i);
            if (visited[now]) continue;
            findDepth(now); 
            ans[node] += ans[now];
            // 재귀 가기 전에 처리하느냐 다녀온 다음에 처리하느냐에 따라 역할이 다름
            // 모든 정점에 자신의 갯수를 1로 초기화해놓고
            // 부모 노드로 돌아와서는 자식의 정점에서의 갯수를 더해줌
        }


    }
}