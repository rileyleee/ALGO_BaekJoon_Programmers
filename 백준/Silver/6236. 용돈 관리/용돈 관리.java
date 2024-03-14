import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, cnt;
    public static int[] spending;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nAndM = br.readLine();
        n = Integer.parseInt(nAndM.split(" ")[0]);
        m = Integer.parseInt(nAndM.split(" ")[1]);

        spending = new int[n];

        int totalSpending = 0;

        int min = 0;

        for (int i = 0; i < n; i++) {
            spending[i] = Integer.parseInt(br.readLine());
            totalSpending += spending[i];
            min = Math.min(min, spending[i]);
        }

        int l = min;
        int r = totalSpending;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            int tmpCnt = getWithdrawCnt(mid);
            
            if (tmpCnt == -1) {
                l = mid + 1;
            } else if (tmpCnt == m) {
                r = mid - 1;
                ans = mid;
            } else if (tmpCnt > m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);

    }

    private static int getWithdrawCnt(int mid) {
        int cnt = 1;
        int possible = 0;
        int remaining = mid;


        for (int s : spending) {
            if (mid < s) {
                return -1;
            }
            if (remaining == 0) {
                cnt++;
                remaining = mid;
            }

            if (s > remaining) { // 부족하면 남은 금액 입금하고 다시 인출
                cnt++;
                remaining = mid;
                remaining -= s;
            } else { // 원칙적으로 인출하지 않으나 인출 가능했던 횟수는 카운팅
                remaining -= s;
                possible++;
            }
        }

        if (cnt < m && cnt + possible >= m) {
            return m;
        }
        return cnt;
    }
}