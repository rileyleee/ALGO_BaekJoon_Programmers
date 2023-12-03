import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int k;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static class Subin {
        int idx;
        int sec;

        public Subin(int idx, int sec) {
            this.idx = idx;
            this.sec = sec;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[100001];

        findMin(n);

        System.out.println(min);
    }

    private static void findMin(int n) {
        Queue<Subin> qu = new LinkedList<>();

        qu.offer(new Subin(n, 0)); // 수빈 초기 위치 넣어주고

        while (!qu.isEmpty()) {
            Subin sb = qu.poll();
            visited[sb.idx] = true; // 방문처리

            // else if 문으로 묶으면 그 아래 가능한 연산을 시도하지 않게 됨
            // 그럼 그냥 100000까지 가버리는 거임
            // 따라서 독립된 조건문으로 각각의 경우를 모두 시도하며 값을 확인해야 함
            if (sb.idx == k) {
                min = Math.min(min, sb.sec);
                //System.out.println("찾았어요 현재 min은: " + min);
            }

            if (sb.idx * 2 <= 100000 && !visited[sb.idx * 2]) { // 순간 이동 경계 내부
                qu.offer(new Subin(sb.idx * 2, sb.sec));
                //System.out.println("순간이동 후 현재 idx은: " + sb.idx * 2);
            }

            if (sb.idx + 1 <= 100000 && !visited[sb.idx + 1]) { // +1 경계 내부
                qu.offer(new Subin(sb.idx + 1, sb.sec + 1));
                //System.out.println("하나 앞으로 현재 idx은: " + (sb.idx + 1));
            }

            if (sb.idx - 1 >= 0 && !visited[sb.idx - 1]) { // -1 경계 내부
                qu.offer(new Subin(sb.idx - 1, sb.sec + 1));
                //System.out.println("하나 뒤로 현재 idx은: " + (sb.idx - 1));
            }
        }
    }
}