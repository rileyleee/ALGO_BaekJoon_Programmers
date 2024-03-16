import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while (true) {
            str = br.readLine();

            if (str.equals(".")) {
                break;
            }
            System.out.println(balance(str));
        }

    }

    private static String balance(String str) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.empty() || stk.peek() != '(') {
                    return "no";
                } else stk.pop();
            } else if (c == ']') {
                if (stk.empty() || stk.peek() != '[') {
                    return "no";
                } else {
                    stk.pop();
                }
            }
        }

        if (stk.empty()) return "yes";
        else return "no";
    }
}