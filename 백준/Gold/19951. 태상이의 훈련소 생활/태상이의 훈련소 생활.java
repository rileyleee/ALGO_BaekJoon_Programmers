import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ground = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        int[] work = new int[n + 2]; // 누적합 때문에 연산이 복원되는 마지막 원소를 위한 자리

        while (m-- > 0) { // 누적합 적용 위한 구분자 처리
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            work[start] += height;
            work[end + 1] += (-height); // 누적합 중지시키기 위한 복원 처리

//            System.out.println("work[" + start + "]: " + work[start]);
//            System.out.println("work[" + (end + 1) + "]: " + work[end + 1]);
        }

        for (int i = 1; i <= n + 1; i++) {
            work[i] = work[i] + work[i - 1];
//            System.out.println("work[" + (i - 1) + "]: " + work[i - 1]);
//            System.out.println("work[" + (i) + "]: " + work[i]);
        }

        //System.out.println(Arrays.toString(work));

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= n; i++) {
            ground[i] += work[i];
            bw.write(ground[i] + " ");
        }

        bw.flush();


    }
}