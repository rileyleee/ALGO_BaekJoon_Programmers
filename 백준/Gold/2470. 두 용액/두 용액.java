import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] solutions;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(solutions);

        //System.out.println(Arrays.toString(solutions));

        int min = Integer.MAX_VALUE;

        int num1 = 0;
        int num2 = 0;

        int l = 0;
        int r = n - 1;

        while (l < r) {

            //System.out.printf("l는: %d, r은: %d\n", l, r);

            if (Math.abs(solutions[l] + solutions[r]) < min) {
                min = Math.abs(solutions[l] + solutions[r]);
                num1 = solutions[l];
                num2 = solutions[r];
                //System.out.printf("** 갱신! 최솟값은: %d, 왼쪽 수는:  %d, 이번 테스트 수는: %d\n", min, num1, num2);
            }

            if (solutions[l] + solutions[r] < 0) {
                l++;
            } else {
                r--;
            }


        }

        System.out.println(num1 + " " + num2);


    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        solutions = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
    }
}