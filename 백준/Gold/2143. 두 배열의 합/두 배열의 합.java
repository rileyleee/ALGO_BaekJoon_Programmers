import java.io.*;
import java.util.*;

public class Main {
    public static int t, n, m;
    public static int[] arrA, arrB, accA, accB;
    public static ArrayList<Integer> combA;
    public static ArrayList<Integer> combB;

    public static void main(String[] args) throws IOException {

        input();

        combA = new ArrayList<>();
        combB = new ArrayList<>();

        getCombination();

        // 이분 탐색을 위해 정렬

        Collections.sort(combA);
        Collections.sort(combB);

        long ans = 0L;


        for (int j = 0; j < combA.size(); j++) {

            int partA = combA.get(j);
            int target = t - partA;

            // target의 lowerBound와 upperBound를 찾아서 ans에 더해주면 된다.


            int s = findLowerBound(target);
            int e = findUpperBound(target);
            ans += e - s;
        }

        System.out.println(ans);
    }

    private static int findLowerBound(int target) {
        // 특정 수 이상의 값이  최초로 등장하는 인덱스 구하기
        int sIdx = combB.size();

        int l = 0;
        int r = combB.size() - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (combB.get(mid) < target) l = mid + 1;
            else {
                sIdx = mid;
                r = mid - 1;
            }
        }
        return sIdx;
    }

    private static int findUpperBound(int target) {
        // 특정 수를 초과하는 값이 최초로 등장하는 인덱스 구하기
        int eIdx = combB.size();

        int l = 0;
        int r = combB.size() - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (combB.get(mid) <= target) l = mid + 1;
            else {
                eIdx = mid;
                r = mid - 1;
            }
        }
        return eIdx;
    }

    private static void getCombination() {

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int tmpSum = accA[j] - accA[i - 1];
                combA.add(tmpSum);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int tmpSum = accB[j] - accB[i - 1];
                combB.add(tmpSum);
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        arrA = new int[n + 1];
        accA = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
            accA[i] = accA[i - 1] + arrA[i];
        }

        m = Integer.parseInt(br.readLine());
        arrB = new int[m + 1];
        accB = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
            accB[i] = accB[i - 1] + arrB[i];
        }
    }
}