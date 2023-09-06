import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();


        int[] arr = new int[n + 1];

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            dq.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!dq.isEmpty()) {
            for (int i = 0; i < k; i++) {

                if ((i == k - 1) && (dq.size() == 1)) {
                    sb.append(dq.removeFirst());
                } else if (i == k - 1) {
                    sb.append(dq.removeFirst()).append(", ");
                } else {
                    dq.offerLast(dq.removeFirst());
                }
            }
        }

        sb.append(">");

        System.out.println(sb.toString());
    }
}