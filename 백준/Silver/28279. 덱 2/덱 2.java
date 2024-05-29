import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();

        while (n-- > 0) {
            int tmp;
            int comm = sc.nextInt();

            switch (comm) {
                case 1:
                    tmp = sc.nextInt();
                    dq.offerFirst(tmp);
                    break;
                case 2:
                    tmp = sc.nextInt();
                    dq.offerLast(tmp);
                    break;
                case 3:
                    if (dq.size() != 0) bw.write(dq.pollFirst() + "\n");
                    else bw.write(-1 + "\n");
                    break;
                case 4:
                    if (dq.size() != 0) bw.write(dq.pollLast() + "\n");
                    else bw.write(-1 + "\n");
                    break;
                case 5:
                    bw.write(dq.size() + "\n");
                    break;
                case 6:
                    if (dq.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case 7:
                    if (dq.size() != 0) bw.write(dq.peekFirst() + "\n");
                    else bw.write(-1 + "\n");
                    break;
                case 8:
                    if (dq.size() != 0) bw.write(dq.peekLast() + "\n");
                    else bw.write(-1 + "\n");
                    break;
            }

        }
        bw.flush();
        bw.close();
    }
}