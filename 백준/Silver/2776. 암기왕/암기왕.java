import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int i =0; i<tc; i++) {

            StringBuilder sb = new StringBuilder();

            int n = sc.nextInt();
            Set<Integer> first = new HashSet<>();

            for (int j = 0; j < n; j++) {
                first.add(sc.nextInt());
            }


            int m = sc.nextInt();

            for (int k = 0; k < m; k++) {
                int thisInt = sc.nextInt();

                if(first.contains(thisInt)){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }
            System.out.print(sb.toString());
        }
    }
}