import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {

            String str = sc.next();

            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();


            for (int i = 0; i < str.length(); i++) {
                char input = str.charAt(i);
                //System.out.println("이번 문자: " + input);

                if (input == '<') {
                    if (!left.isEmpty()) {
                        //System.out.println("왼쪽에서 오른쪽으로 넣음: " + left.peek());
                        right.push(left.pop());
                    }
                } else if (input == '>') {
                    if (!right.isEmpty()) {
                        //System.out.println("오른쪽에서 왼쪽으로 넣음: " + right.peek());
                        left.push(right.pop());
                    }
                } else if (input == '-') {
                    //System.out.println("왼쪽에서 이거 꺼냄: " + left.peek());
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(input);
                    //System.out.println("왼쪽에 넣었어요");
                }
            }
            // 커서 오른쪽에 있는 값 다시 왼쪽으로 넣어주기
            while (!right.isEmpty()) left.push(right.pop());

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) sb.append(left.pop());


            System.out.println(sb.reverse());

        }

    }
}