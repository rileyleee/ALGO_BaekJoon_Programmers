import java.util.*;

public class Main {
    public static int n, min, teamCapa;
    public static int[][] arr;
    public static int[] team1, team2, pair;
    public static HashSet<Integer> tmp;
    public static boolean[] visited, eachVisited;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n 입력 받고
        n = sc.nextInt();

        // 배열 입력 받고
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt();

        team1 = new int[n / 2];
        team2 = new int[n / 2];
        pair = new int[2];

        visited = new boolean[n + 1];
        eachVisited = new boolean[n / 2];

        tmp = new HashSet<>();

        min = Integer.MAX_VALUE;

        // 1부터 n까지 n/2 명씩 뽑기
        makeTeam(0);

        System.out.println(min);
    }

    private static void makeTeam(int curr) {
        if (curr == n / 2) {

            // team2 만들어주기
            int idx = 0;
            for (int i = 1; i <= n; i++)
                if (!tmp.contains(i)) team2[idx++] = i;

            //System.out.println(Arrays.toString(team1));
            //System.out.println(Arrays.toString(team2));

            teamCapa = 0;
            sumCapa(team1, 0);
            int one = teamCapa;

            teamCapa = 0;
            sumCapa(team2, 0);
            int two = teamCapa;


            // 각 능력치의 최솟값 갱신하기
            min = Math.min(min, Math.abs(one - two));

            //System.out.println("==============================");
            return;
        }

        for (int i = 1; i <= n; i++) {

            // 이미 뽑았거나 이전에 뽑은 수보다 같거나 작으면 지나가기
            if (visited[i] || (curr > 0 && team1[curr - 1] >= i)) continue;

            team1[curr] = i;
            tmp.add(i);
            visited[i] = true;
            makeTeam(curr + 1);
            visited[i] = false;
            team1[curr] = 0;
            tmp.remove(i);
        }
    }

    private static void sumCapa(int[] eachTeam, int curr) {

        // 팀 내부에서 2명씩 뽑아서 배열의 능력치 더하기
        if (curr == 2) {
            teamCapa += arr[pair[0]][pair[1]];
            //System.out.println("현재 능력치: " + teamCapa + " " + pair[0] + "과" + pair[1]);
            return;
        }

        for (int i = 0; i < eachTeam.length; i++) {
            if (eachVisited[i]) continue;

            pair[curr] = eachTeam[i];
            eachVisited[i] = true;
            sumCapa(eachTeam, curr + 1);
            pair[curr] = 0;
            eachVisited[i] = false;
        }


    }
}