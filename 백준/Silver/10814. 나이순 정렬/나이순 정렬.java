import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String>[] ages = new ArrayList[201];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = new ArrayList<String>();
        }

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            ages[age].add(name);
        }

        for (int i = 0; i < ages.length; i++) {

            if (ages[i].size() != 0) {
                for (int j = 0; j < ages[i].size(); j++) {
                    System.out.println(i + " " + ages[i].get(j));
                }
            }
        }
    }
}