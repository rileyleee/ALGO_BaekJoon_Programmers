import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 카드의 개수와 합체 횟수를 입력받고
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 우선순위 큐를 구현해
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 카드 숫자를 입력받는다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        // 합체 횟수만큼 반복문을 돌면서
        for (int i = 0; i < m; i++) {
            long mergedNum = pq.poll() + pq.poll();
            pq.offer(mergedNum);
            pq.offer(mergedNum);
        }

        long answer = 0;

        long[] ansArr = pq.stream().mapToLong(Long::longValue).toArray();

        // 큐의 모든 값을 더해서 반환한다.
        for (long i : ansArr) answer += i;

        System.out.println(answer);
    }
}