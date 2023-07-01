import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int up = sc.nextInt();
        int down = sc.nextInt();
        int h = sc.nextInt();

        int day = 1;

        int moreDays = (h - up) / (up - down); // 미끄러지고 올라가는 것을 하나로 며칠이 걸릴지
        int plus = (h - up) % (up - down); // 딱 떨어지지 않았을 경우 하루 더 해주기 위함

        if (moreDays == 0) {
            day++; // 올라갈 수 있는 높이가 남은 높이보다 높을 때 하루만 더해줘
        } else {
            day += moreDays; // 남은 높이가 더 높으면 걸리는 일 수 더해주고
        }

        if (moreDays != 0 && plus > 0) { // 높이 더 남았으면 하루치 더 더해주자.
            day++;
        }

        if (up == h) { //근데 첫날에 다 올라갈 수도 있잖아?
            day = 1;
        }

        System.out.println(day);
    }
}