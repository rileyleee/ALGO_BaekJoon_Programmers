import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Integer>> points = new ArrayList<>();
    static boolean[] visited; //정점 방문여부
    static int[] parents; //부모 정점 담기 위한 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nNum = sc.nextInt();

        for (int i = 0; i <= nNum; i++) { // 정점 수 만큼 반복문 돌기
            points.add(new ArrayList<>()); //어레이리스트로 초기화하기 -> 안 하면 null 오류
        }

        for (int i = 0; i < nNum - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            points.get(n1).add(n2); //서로 연결 되어 있으니까 양 방향에 다 담기
            points.get(n2).add(n1);
        }
        //인덱스 배열 사용할거라서 +1
        visited = new boolean[nNum + 1];
        parents = new int[nNum + 1];

        DFS(1); //루트 정점부터 시작

        for (int i = 2; i < parents.length; i++) { //2번부터 알려주면 된다.
            System.out.println(parents[i]);
        }

    }

    private static void DFS(int i) {
        visited[i] = true; // 방문처리

        for (int e : points.get(i)) { //해당 정점과 연결된 정점들 반복문 돌기
            if (!visited[e]) {
                DFS(e);
                parents[e] = i;
            }
        }
    }
}