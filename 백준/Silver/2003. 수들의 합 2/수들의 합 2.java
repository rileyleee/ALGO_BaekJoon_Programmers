import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(arr));


        int cnt = 0;

        int rightIdx = 1;

        int currentSum = arr[1];

        for (int i = 1; i <= n; i++) {
            while (currentSum < m && rightIdx < n) {
                currentSum += arr[++rightIdx];
            }
            if (currentSum == m) cnt++;
            // 만약 현재까지 더한 값이 m과 같은 게 아니라 컸다면 이 시작점에서는 m을 만들 구간이 없다는 것을 의미하니까
            // 시작점의 값을 뺀 기존의 합인 값이 m과 비교해서 작은지 큰지 또 비교한다.
            currentSum -= arr[i];
        }
        System.out.println(cnt);
    }

}