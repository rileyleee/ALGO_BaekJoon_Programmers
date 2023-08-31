import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Integer> deq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();


        int comm = sc.nextInt();

        for (int i = 0; i < comm; i++) {
            String thisComm = sc.next();
            switch (thisComm) {
                case "push_front":
                    deq.offerFirst(sc.nextInt());
                    break;
                case "push_back":
                    deq.offerLast(sc.nextInt());
                    break;
                case "pop_front":
                    if (deq.peekFirst() != null) {
                        sb.append(deq.pollFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deq.peekLast() != null) {
                        sb.append(deq.pollLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "front":
                    if (deq.peekFirst() != null) {
                        sb.append(deq.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (deq.peekLast() != null) {
                        sb.append(deq.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deq.size()).append("\n");
                    break;
                case "empty":
                    if (deq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}