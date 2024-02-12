import java.util.Scanner;

public class Main {
    public static int[][] times;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        // 0행은 현재 시각, 1행은 선생님이 컵을 사용하는 시각
        // 시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.

        StringBuilder sb = new StringBuilder();

        int hour = 0;
        int minute = 0;
        int seconds = 0;

        if (times[0][0] == times[1][0] && times[0][1] == times[1][1] && times[0][2] == times[1][2]) {
            sb.append("24" + ":" + "00" + ":" + "00");
        } else {

            if (times[1][2] < times[0][2]) {
                times[1][1]--;
                seconds = 60 - times[0][2] + times[1][2];
            } else {
                seconds = times[1][2] - times[0][2];
            }

            if (times[1][1] < times[0][1]) {
                times[1][0]--;
                minute = 60 - times[0][1] + times[1][1];
            } else {
                minute = times[1][1] - times[0][1];
            }

            if (times[1][0] < times[0][0]) {
                hour = 24 - times[0][0] + times[1][0];
            } else {
                hour = times[1][0] - times[0][0];
            }

            if (hour < 10) {
                sb.append("0" + hour + ":");
            } else {
                sb.append(hour + ":");
            }

            if (minute < 10) {
                sb.append("0" + minute + ":");
            } else {
                sb.append(minute + ":");
            }

            if (seconds < 10) {
                sb.append("0" + seconds);
            } else {
                sb.append(seconds);
            }

        }


        System.out.println(sb.toString());

    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        times = new int[2][3];

        // 현재시각의 시분초와 선생님이 컵을 사용하는 시각의 시분초를 배열에 담기
        for (int i = 0; i < 2; i++) {
            String timeline = sc.next();
            times[i][0] = Integer.parseInt(timeline.split(":")[0]);
            times[i][1] = Integer.parseInt(timeline.split(":")[1]);
            times[i][2] = Integer.parseInt(timeline.split(":")[2]);
        }
    }
}