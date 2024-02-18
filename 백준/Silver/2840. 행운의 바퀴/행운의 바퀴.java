import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] wheel = new char[n];

        for (int i = 0; i < n; i++) wheel[i] = '?';


        boolean[] writeAlpha = new boolean[26];

        StringBuilder sb = new StringBuilder();

        int spin = sc.nextInt();
        char alpha = sc.next().charAt(0);

        wheel[0] = alpha;

        writeAlpha[alpha - 'A'] = true;

        int pointer = 0;

        boolean exist = true;

        while (k-- > 1) {

            spin = sc.nextInt();
            alpha = sc.next().charAt(0);

            if (pointer + spin % n > n - 1) {
                pointer = spin % n - (n - pointer);
            } else {
                pointer += spin % n;
            }
            // 입력 절차
            if (wheel[pointer] == '?') { // 빈칸이고
                if (!writeAlpha[alpha - 'A']) { // 아직 이 알파벳 입력한 적 없으면
                    wheel[pointer] = alpha;
                    writeAlpha[alpha-'A'] = true;
                } else { // 근데 입력한 적 있으면 -> 다른 위치에 같은 알파벳 입력하는 거니까 존재할 수 없는 바퀴
                    exist = false;
                }
            } else if (wheel[pointer] == alpha) {
                continue;
            } else { // 빈칸도 아니고 지금 입력하려는 알파벳도 아닌 애가 있어 그럼 존재할 수 없는 바퀴
                exist = false;
            }
        }

        if (exist) {

            for (int i = n-1; i >=0; i--) {
                sb.append(wheel[(pointer + i+1) % n]);
            }

//            // 역순으로 출력하기
//            for (int i = pointer; i >= 0; i--) {
//                sb.append(wheel[i]);
//                //System.out.println("i: "+i);
//            }
//            if (pointer != n - 1) {
//                for (int i = n - 1; i > pointer; i--) {
//                    sb.append(wheel[i]);
//                    //System.out.println("i: "+i);
//                }
//            }
            System.out.println(sb.toString());
        } else {
            System.out.println("!");
        }
    }
}