import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static int n,k;
    private static int pool[];
    private static boolean visited[];
    private static HashSet<String> answer;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        pool = new int [n];
        visited = new boolean[n];

        for(int i =0; i<n; i++){
            pool[i] = sc.nextInt();
        }

        //System.out.println(Arrays.toString(pool));

        answer = new HashSet<>();

        makeNum("", 0);

        System.out.println(answer.size());

    }
    private static void makeNum(String num, int cnt){
        StringBuilder sb;
        //System.out.println("cnt는: "+cnt);
        if(cnt == k){
            //System.out.println(num+" 답에 추가");
            answer.add(num);
            return;
        }

        if(cnt<k) { //앞뒤로만 붙여서는 안된다.. -> 본인 숫자 제외하고 조합하기
            for (int i = 0; i < n; i++) {
                if(visited[i]) continue;
                sb = new StringBuilder();
                String tmp1 = sb.append(num).append(pool[i]).toString();
                visited[i] = true;
                //System.out.println("tmp1: "+tmp1);
                makeNum(tmp1, cnt + 1);
                visited[i] = false;
            }

        }
    }
}