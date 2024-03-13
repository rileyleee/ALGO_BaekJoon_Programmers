import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(trees);

        long l = 0; // 모든 나무를 뿌리까지 베어야 하는 경우
        long r = max - 1; // m의 최소 길이는 1이기 때문에 가장 큰나무보다 1m 작게 설정
        long h = -1L;

        while (l <= r) {
            long mid = (l + r) / 2;

            //System.out.printf("l는 %d mid은 %d r는 %d", l, mid, r);
            //System.out.println();
            // 길이가 mid 일 경우 가져갈 수 있는 나무의 총 길이
            long tmp = getTotalLength(mid);

            // 가져갈 수 있는 나무의 길이가 목표보다 작으면
            if (tmp == m) {
                h = mid;
                break;
            } else if (tmp > m) {
                h = mid;
                //System.out.println("현재 h: " + h);
                l = mid + 1;
                //System.out.println("l 늘렸어요: " + l);
            } else {
                r = mid - 1;
                //h = mid;
                //System.out.println("r 줄였어요: " + r);
                //System.out.println("현재 h: " + h);
            }
        }
        System.out.println(h);
    }

    private static long getTotalLength(long mid) {

        int start = 0;
        int end = n - 1;
        int firstIdx = -1;
        long totalLength = 0;

        while (start <= end) {
            int middle = (start + end) / 2;

            //System.out.printf("start는 %d middle은 %d end는 %d", start, middle, end);
            //System.out.println();
            if (trees[middle] < mid) {
                start = middle + 1;
                // System.out.println("start 늘렸어요: " + start);
            } else if (trees[middle] <= mid) {
                firstIdx = middle;
                //System.out.println("firstIdx: " + firstIdx);
                start = middle + 1;
                //System.out.println("start 늘렸어요: " + start);
            } else {
                firstIdx = middle;
                end = middle - 1;
                //System.out.println("end 줄였어요: " + end);
                //System.out.println("firstIdx: " + firstIdx);
            }
        }

        for (int i = firstIdx; i < n; i++) {
            //System.out.println("i: " + i);

            totalLength += trees[i] - mid;
        }
        //System.out.println("자르고자 하는 높이: " + mid);
        //System.out.println("현재 길이: " + totalLength);
        return totalLength;
    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        max = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        //System.out.println("max: " + max);
    }
}