import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Integer> qu = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            qu.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        while (!qu.isEmpty()) {


            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    sb.append(qu.poll() + ", ");
                } else {
                    qu.addLast(qu.poll());
                }
            }


        }
        sb.replace(sb.length()-2, sb.length(),">");

        System.out.println(sb.toString());


    }
}