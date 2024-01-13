import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int[] times = new int[8001];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];

            // 빈도 수 계산
            if (arr[i] >= 0) {
                times[arr[i]]++;
            } else {
                times[(-1 * arr[i]) + 4000]++;
            }
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int avg = Math.round((float) sum / n);

        // 산술평균
        sb.append(avg);
        // 중앙값
        sb.append("\n").append(arr[n / 2]);
        // 최빈값

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < times.length; i++) {
            max = Math.max(max, times[i]);
        }

        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            if (times[i] == max) {
                if (i <= 4000) {
                    list.add(i);
                } else {
                    list.add((i - 4000) * -1);
                }
            }
        }

        Collections.sort(list);

        if (list.size() == 1) {
            sb.append("\n").append(list.get(0));
        } else {

            sb.append("\n").append(list.get(1));
        }

        // 범위
        sb.append("\n").append(arr[n - 1] - arr[0]);

        System.out.println(sb.toString());

    }
}