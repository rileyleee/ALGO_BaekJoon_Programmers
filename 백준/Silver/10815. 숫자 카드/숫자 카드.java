import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hs.add(sc.nextInt());
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int thisNum = sc.nextInt();
            if (hs.contains(thisNum)) {
                sb.append("1").append(" ");
            }else{
                sb.append("0").append(" ");
            }
        }

        System.out.println(sb.toString());

    }
}