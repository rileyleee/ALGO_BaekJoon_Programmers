import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static final int INF = 1000000000;
    static int N, M, X, Y;
    static int[][] adj; // 인접 행렬
    static int[] dist; // 최소 거리 비용 테이블
    static boolean[] visited; // 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        StringTokenizer st = null;
         
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
         
        adj = new int[N+1][N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                // i == j 이면 adj[i][j] = 0;
                if(i != j) adj[i][j] = INF;
            }           
        }
         
        int u, v, cost;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            // 서로 다른 두 정점간 여러 경로 값이 주어질 수 있기에 더 작은 비용으로 갱신
            adj[u][v] = Math.min(adj[u][v], cost);    
        }
         
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
         
        // 다익스트라 알고리즘
        dijkstra(X);
 
        System.out.println(dist[Y]);
    }
      
    private static void dijkstra(int start) {
        // 시작점에서의 dist[] 배열 초기화
        for(int i=1; i<=N; i++) {
            dist[i] = adj[start][i];
        }
        // 방문 처리
        visited[start] = true;
        for(int i=1; i<= N-2; i++) {
            // 방문하지 않은 정점 중 가장 작은 비용의 정점을 찾는다.
            int current = getSmallIndex();
            visited[current] = true; // 방문 처리
            // 방문하지 않은 정점들 중 연결된 정점의 최단거리 갱신
            for(int j=1; j<=N; j++) {
                if(!visited[j]) {
                    dist[j] = Math.min(dist[j], dist[current] + adj[current][j]);
                }
            }
        }
    }
 
    private static int getSmallIndex() {
        int min = INF;
        int idx = 1;
        for(int i=1; i<=N; i++) {
            // 방문하지 않은 정점 중 가장 작은 비용의 정점을 찾는다.
            if(!visited[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }
}