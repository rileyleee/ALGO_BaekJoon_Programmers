import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 투 포인터를 사용하면 시간 복잡도 n^2를 n으로 줄일 수 있다.
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n + m];

        for (int i = 0; i < n + m; i++) {
            arr[i] = sc.nextInt();
        }

        // 여기서부터 투포인터 활용 정렬 각 배열은 정렬되어 있따.. 이런..
        // {3,5,2,9}
        int left = 0;
        int right = n;

        int[] answer = new int[n + m];
        int idx = 0;

        while (left < n && right < (n + m)) {

            if (arr[left] < arr[right]) {
                answer[idx++] = arr[left++];
                //System.out.println("left: " + left);
            } else {
                answer[idx++] = arr[right++];
                //System.out.println("right: " + right);
            }
        }

        while (left < n) {
            answer[idx++] = arr[left++];
        }

        while (right < n + m) {
            answer[idx++] = arr[right++];
        }

        for (int i = 0; i < n + m; i++) {
            sb.append(answer[i]+" ");
        }

        System.out.println(sb.toString());


    }
}