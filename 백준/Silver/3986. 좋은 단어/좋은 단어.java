import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < num; i++) {

            String word = sc.next();
            Stack<Character> stk = new Stack<>();

            for (int j = 0; j < word.length(); j++) {
                char thisChar = word.charAt(j);

                if (stk.isEmpty() || stk.peek() != thisChar) {
                    stk.push(thisChar);
                } else {
                    stk.pop();
                }
            }

            if (stk.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}