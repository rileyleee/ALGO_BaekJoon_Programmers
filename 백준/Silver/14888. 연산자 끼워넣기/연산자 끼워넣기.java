import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int n, min, max;
    public static HashMap<Integer, Character> cal;
    public static int[] calArr, arr, selected;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n의 갯수 입력 받기
        n = sc.nextInt();

        // n 배열 입력 받기
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // 연산자의 갯수 배열로 입력받기
        calArr = new int[4]; // "+, -, *, /" 의 순서
        for (int i = 0; i < 4; i++) calArr[i] = sc.nextInt();

        // 최솟값 최댓값 변수 초기화하기
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        // 연산자 해시맵
        cal = new HashMap<>();
        cal.put(0, '+');
        cal.put(1, '-');
        cal.put(2, '*');
        cal.put(3, '/');

        // n-1의 길이를 갖는 연산자 배열 만들기
        selected = new int[n - 1];

        arrange(0);

        // 출력하기
        System.out.print(max + "\n" + min);
    }

    private static void arrange(int curr) {

        if (curr == n - 1) {
            // 다 배치하면 연산하고 최솟값 최댓값 갱신해주기
            //System.out.println(Arrays.toString(selected));
            int tmp = arr[0];
            for (int i = 1; i < n; i++) {
                switch (selected[i - 1]) {
                    case 0:
                        tmp += arr[i];
                        break;
                    case 1:
                        tmp -= arr[i];
                        break;
                    case 2:
                        tmp *= arr[i];
                        break;
                    case 3:
                        if (tmp < 0) tmp = (-tmp / arr[i]) * -1;
                        else tmp /= arr[i];
                }
            }

            min = Math.min(min, tmp);
            max = Math.max(max, tmp);

            return;
        }

        // 재귀 돌면서 연산자 경우의 수 만들기
        for (int i = 0; i < 4; i++) {
            if (calArr[i] == 0) continue;

            selected[curr] = i;
            calArr[i]--;
            arrange(curr + 1);
            selected[curr] = 0;
            calArr[i]++;

        }


    }
}