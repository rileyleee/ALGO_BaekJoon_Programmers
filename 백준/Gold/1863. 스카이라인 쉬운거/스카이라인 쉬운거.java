import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] why = new int[50002];
        Stack<Integer> stk = new Stack<>();

        int n = sc.nextInt();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            why[i] = y;
        }

        for (int i = 0; i <= n; i++) {
            // 0인 경우를 별도로 처리하지 않았기 때문에 0은 세지 않고 지나가도록 stk.size()를 더하는 방식 대신 아래 로직을 한 번 더 돌도록 처리
            //System.out.println("스택에 작업 중인 인덱스: "+i);
            //System.out.println("스택에 작업 중인 값: "+why[i]);

            while (!stk.isEmpty() && stk.peek() > why[i]) {
                //System.out.println("최상단값 지웁니다: "+stk.peek());
                stk.pop();
                cnt++;
            }

            if (!stk.isEmpty() && stk.peek() == why[i]) {
                //System.out.println("같아서 지나가요");
                continue;
            }

            stk.push(why[i]);
            //System.out.println("스택에 넣은 값: "+why[i]);

        }

        System.out.println(cnt);
    }

}