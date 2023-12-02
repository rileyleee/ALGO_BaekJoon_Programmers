import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            check(i);
        }

        System.out.println(answer);
    }

    private static void check(int i) {

        String num = Integer.toString(i);

        if(num.length()<=2){
            answer++;
        }else {

            boolean same = true;
            for (int n = 1; n < num.length(); n++) {
                int firstDiff = num.charAt(1) - num.charAt(0);
                if (firstDiff != num.charAt(n) - num.charAt(n-1)) {
                    same = false;
                }
            }

            if (same) {
                answer++;
            }
        }
    }
}