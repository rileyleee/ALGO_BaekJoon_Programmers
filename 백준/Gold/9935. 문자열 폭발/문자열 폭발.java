import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String originStr = sc.next();
        String expdStr = sc.next();

        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < originStr.length(); i++) {
            stk.add(originStr.charAt(i));

            // 이중 반복문을 사용할 필요 없이 폭발 문자열이 포함될 수 있는 길이라면
            // 매 입력 시 마다 탐색해서 stk에서 제거

            if (stk.size() >= expdStr.length()) {
                boolean find = true;

                for (int j = 0; j < expdStr.length(); j++) {
                    if (stk.get(stk.size() - expdStr.length() + j) != expdStr.charAt(j)) {
                        find = false;
                        break;
                    }
                }

                if (find) {
                    for (int j = 0; j < expdStr.length(); j++) {
                        stk.pop();
                    }
                }
            }
        }

        for (int i = 0; i < stk.size(); i++) {
            sb.append(stk.get(i));
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());

    }
}