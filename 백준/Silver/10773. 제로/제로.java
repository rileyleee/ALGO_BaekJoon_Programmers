import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            int thisNum = sc.nextInt();
            if (thisNum == 0) {
                //System.out.println(stk.peek() + "가 지워졌어요.");
                stk.pop();
            } else if (thisNum != 0) {
                stk.add(thisNum);
            }
        }

        int answer = 0;
        int len = stk.size();

        //System.out.println(stk.size() + "현재 크기에요.");

//        if (stk.size() != 0) {

        for (int i = 1; i <= len; i++) { // 아 동적으로 길이 변경
           // System.out.println(stk.peek() + "가 더해졌어요.");
            answer += stk.pop();
        }
//        } else {
//            answer = 0;
//        }

        System.out.println(answer);
    }
}