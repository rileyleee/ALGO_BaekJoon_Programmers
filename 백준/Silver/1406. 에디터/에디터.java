import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String originStr = sc.next();

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < originStr.length(); i++) {
            list.add(originStr.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator();

        // 초기의 커서는 리스트의 제일 앞에 있음

        // 맨 뒤에 커서가 있다고 하니까!
        while (iterator.hasNext()) {
            iterator.next();
        }
        // 위 방식 대신 선언할 때 아예 위치를 맨 뒤로 옮겨놓고 시작할 수도 있음
        // ListIterator<Character> iterator = list.listIterator(originStr.length());

        int commNum = sc.nextInt();

        while (commNum-- > 0) {
            String comm = sc.next();

            switch (comm) {
                case "L":
                    if (iterator.hasPrevious()) iterator.previous();
                    //System.out.println(list);
                    break;
                case "D":
                    if (iterator.hasNext()) iterator.next();
                    //System.out.println(list);
                    break;
                case "B":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                        // remove 연산은 직전에 참조했던 값을 지우기 때문에 우리가 원하는 값을
                        // 지우기 위해서는 앞으로 한 칸 이동한다면 이제 참조하는 값이 우리가 처리하고자 하는 값이 된다.
                    }
                    //System.out.println(list);
                    break;
                case "P":
                    String letter = sc.next();
                    iterator.add(letter.charAt(0)); // next 앞에 새 노드를 연결 next가 없으면 previous 뒤쪽에 연결
                    //System.out.println(list);
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            sb.append(c);
        }

        System.out.println(sb.toString());


    }
}