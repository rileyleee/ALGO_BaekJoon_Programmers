import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] compliments;
    private static ArrayList[] struct;
    private static BufferedWriter bw;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {

        // 직원 수 n, 최초 칭찬 수 m 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 인접리스트 만들기
        struct = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) struct[i] = new ArrayList<Integer>();

        // 인덱스가 부하, 값이 상사인 형태로 인접 리스트 채우기 -> 단 방향 가능하지 않을까
        st = new StringTokenizer(br.readLine());

        int root = -1;

        for (int i = 1; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());

            if (boss == -1) root = i;
            else struct[boss].add(i);
        }

        // 직원별 칭찬 점수 배열 만들고
        compliments = new int[n + 1];

        // 방문 배열 만들고
        visited = new boolean[n + 1];

        // m번 반복문 돌면서 칭찬 받은 점수 더해놓기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            // 칭찬 받은 직원 (receiver) 칭찬 점수 더해주기
            int receiver = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            compliments[receiver] += score;
        }

        //System.out.println(Arrays.toString(compliments));

        addScore(root);


        br.close();

        for (int i = 1; i <= n; i++) bw.write(compliments[i] + " ");

        bw.flush();
        bw.close();
    }

    private static void addScore(int curr) {
        //System.out.println("현재 직원: " + receiver + "현재 점수: " + score);
        visited[curr] = true;

        for (int i = 0; i < struct[curr].size(); i++) {
            int nextEmployee = (int) struct[curr].get(i);

            if (visited[nextEmployee]) continue;

            compliments[nextEmployee] += compliments[curr];


            addScore(nextEmployee);
        }

    }
}