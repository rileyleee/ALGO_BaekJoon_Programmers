import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        String ans = "";

        while (t-- > 0) {
            //System.out.println("========================================");

            int n = sc.nextInt();

            boolean palindrome = false;

            for (int i = 2; i <= 64; i++) {
                //System.out.println("i: " + i);

                int thisNum = n;

                StringBuilder sb = new StringBuilder();

                // 단순히 수를 더하면 안되는 이유가
                // 서로 다른 연산에서 문자열에 더해졌는데 우연히 맞아 떨어질 수 있으니까 그러니까 진법 구분을 해줘야 한단 소리
                while (thisNum >= i) {
                    int remaining = thisNum % i;

                    if (i > 10) {
                        remaining += 55;
                        sb.append((char) remaining); // 어쨌든 다른 문자만 더해지면 되니까...
                    } else {
                        sb.append(remaining);
                    }

                    thisNum /= i;

                    //System.out.println("thisNum: " + thisNum);
                    //System.out.println("remaining: " + remaining);
                }
                if (i > 10) {
                    thisNum += 55;
                    sb.append((char) thisNum);
                } else {
                    sb.append(thisNum);
                }

                String originOrder = sb.toString();
                String reverseOrder = sb.reverse().toString();

                //System.out.println("originOrder: " + originOrder);
                //System.out.println("reverseOrder: " + reverseOrder);

                if (originOrder.equals(reverseOrder)) palindrome = true;

                if (palindrome) {
                    ans += "1" + "\n";
                    break;
                }

            }

            if (!palindrome) {
                ans += "0" + "\n";
            }


        }
        System.out.println(ans);
    }
}