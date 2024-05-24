import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> deq = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] targetArr = new int[m];

        for (int i = 0; i < m; i++)
            targetArr[i] = sc.nextInt();

        for (int i = 1; i <= n; i++)
            deq.offer(i);

        int answer = 0;


        int midIdx = -1;

        for (int i = 0; i < m; i++) {

            int target = targetArr[i];

            if (deq.size() % 2 == 0) midIdx = deq.size() / 2 - 1;
            else midIdx = deq.size() / 2;

            while (deq.getFirst() != target) {

                if (deq.indexOf(target) > midIdx)
                    deq.offerFirst(deq.pollLast());
                else deq.offerLast(deq.pollFirst());

                answer++;
            }

            deq.pollFirst();
        }


        System.out.println(answer);

    }
}