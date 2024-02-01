import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }

        long sum = 0;

        while (!pq.isEmpty()) {


            if (pq.size() >= 2) {
                // 가장 적은 카드 수를 가진 더미 순으로 뽑기
                long a = pq.poll();
                long b = pq.poll();

                sum += (a + b);

                pq.add(a + b);
            } else {
                break;

            }
        }

        System.out.println(sum);


    }
}