import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numStr = sc.next();
        Character[] num = new Character[numStr.length()];

        for(int i =0; i<numStr.length(); i++){
            num[i] = numStr.charAt(i);
        }

        Arrays.sort(num, (o1, o2) -> o2-o1);

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<num.length; i++){
            sb.append(num[i]);
        }

        System.out.println(sb.toString());

    }
}