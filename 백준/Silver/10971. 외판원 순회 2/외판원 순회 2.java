import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] arr;
    public static boolean[] visited;
    public static int ans;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();


        for (int i = 0; i < n; i++) { // 시작 도시
            int tmp = 0;
            tour(i, 0, tmp, i);
        }

        System.out.print(ans);
    }

    public static void tour(int currCity, int curr, int cost, int start) {

        if (curr == n - 1) {
            if (arr[currCity][start] == 0) return; //마지막 돌아오는 길이 없을 수도 있기 때문에 해당 케이스 제외해줘야 함
            cost += arr[currCity][start];
            ans = Math.min(cost, ans);
            //System.out.println("cost: " + cost);
            //System.out.println("ans: " + ans);
            return;
        }


        for (int i = 0; i < n; i++) {
            if (i == start || visited[i] || arr[currCity][i] == 0) continue; // 이미 순회했거나 같은 도시 또는 갈 수 없는 경우

            visited[i] = true;
            cost += arr[currCity][i];
            //System.out.println("현재도시: " + currCity);
            //System.out.println("다음도시: " + i);
            //System.out.println("현재비용: " + cost);
            //System.out.println("==========================");
            tour(i, curr + 1, cost, start);
            visited[i] = false;
            cost -= arr[currCity][i];

        }
    }

}