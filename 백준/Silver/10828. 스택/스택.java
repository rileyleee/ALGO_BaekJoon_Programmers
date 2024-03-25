import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commNum = Integer.parseInt(br.readLine());

        // 1) Stack으로 구현
        Stack<Integer> stk1 = new Stack<>();
        Deque<Integer> stk2 = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        while (commNum-- > 0) {
            String[] comm = br.readLine().split(" ");

            switch (comm[0]) {
                case "push":
                    int num = Integer.parseInt(comm[1]);
                    stk2.addFirst(num);
                    break;
                case "pop":
                    if (stk2.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(stk2.pollFirst() + "\n");
                    break;
                case "size":
                    sb.append(stk2.size() + "\n");
                    break;
                case "empty":
                    if (stk2.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "top":
                    if (stk2.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(stk2.peekFirst() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}