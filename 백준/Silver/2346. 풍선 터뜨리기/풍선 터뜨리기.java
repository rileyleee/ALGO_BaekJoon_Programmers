import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Deque<int[]> dq = new ArrayDeque<>();

        int[] balloons = new int[n]; // 굳이 별도 클래스 만들지 않고 정수 배열로 처리

        for (int i = 0; i < n; i++) {
            balloons[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1 ");

        int move = balloons[0];

        for (int i = 1; i < n; i++) { // 풍선 인덱스와 이동 값을 넣음
            dq.add(new int[]{i + 1, balloons[i]});
        }

        while (!dq.isEmpty()) {


            // 양수인 경우
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    dq.add(dq.poll());
                }

                int[] next = dq.poll();
                move = next[1]; // 이동값
                sb.append(next[0] + " ");

            } else { // 음수인 경우
                for (int i = 1; i < -move; i++) {
                    dq.addFirst(dq.pollLast());
                }

                int [] next = dq.pollLast();
                move = next[1];
                sb.append(next[0] + " ");
            }
        }

        System.out.println(sb.toString());
    }
}