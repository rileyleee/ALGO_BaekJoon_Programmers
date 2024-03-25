import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commNum = Integer.parseInt(br.readLine());

        // Stack으로 구현
        Stack<Integer> stk1 = new Stack<>();

        StringBuilder sb = new StringBuilder();

        while (commNum-- > 0) {
            String[] comm = br.readLine().split(" ");

            switch (comm[0]) {
                case "push":
                    int num = Integer.parseInt(comm[1]);
                    stk1.push(num);
                    break;
                case "pop":
                    if (stk1.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(stk1.pop() + "\n");
                    break;
                case "size":
                    sb.append(stk1.size() + "\n");
                    break;
                case "empty":
                    if (stk1.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "top":
                    if (stk1.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(stk1.peek() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}