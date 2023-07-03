import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static public class Node implements Comparable<Node> {
        int a, b, cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { //비용 순으로 정렬
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Node>[] flow = new ArrayList[n + 1];
        boolean visited[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            flow[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = sc.nextInt();
                flow[i].add(new Node(i, j, cost));
                flow[j].add(new Node(j, i, cost));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        //1번 행성에서 시작
        visited[1] = true;

        int connection = 1; // 행성 개수와 모두 연결되는지 확인

        //1번 행성과 연결된 모든 행성을 우선순위 큐에 담기
        for (int i = 0; i < flow[1].size(); i++) {
            pq.offer(flow[1].get(i));
        }

        long flowCost = 0;

        while (connection != n) {
            Node curr = pq.poll();
            //현재 행성의 첫번째 연결 행성이 이미 방문한 적이 있다면 지나가
            if (visited[curr.b]) continue;

            //아니라면 비용 더하기(비용이 적은 순)
            flowCost += curr.cost;

            //도착 행성과 연결된 모든 행성 우선순위 큐에 담기
            for (int i = 0; i < flow[curr.b].size(); i++) {
                pq.offer(flow[curr.b].get(i));
            }
            visited[curr.b] = true;
            connection++;
        }
        System.out.println(flowCost);
    }
}