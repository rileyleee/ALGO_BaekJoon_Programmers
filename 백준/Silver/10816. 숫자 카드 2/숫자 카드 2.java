import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] cardArr = new int[20000001];

        st = new StringTokenizer(br.readLine());

        // 인덱스 접근이라 O(1)
        while (n-- > 0) {
            cardArr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        while (m-- > 0) {

            int thisNum = Integer.parseInt(st.nextToken());

            sb.append(cardArr[thisNum + 10000000] + " ");
        }

        System.out.println(sb);

    }
}