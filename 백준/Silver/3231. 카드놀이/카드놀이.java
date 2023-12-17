import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] cardArr = new int[num+1];

        for (int i = 0; i < num; i++) {
            int c = sc.nextInt();
            cardArr[c] = i;
        }

        int clap = 0;

        for (int i = 1; i <= num; i++) {
            if (cardArr[i] - cardArr[i - 1] < 0) {
                clap++;
            }
        }
        System.out.println(clap);
    }
}