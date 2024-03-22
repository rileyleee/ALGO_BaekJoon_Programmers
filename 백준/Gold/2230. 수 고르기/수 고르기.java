import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        long min = Long.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (left < n && right < n) {
            //System.out.printf("left는 %d, right는 %d", left, right);

            if (arr[right] - arr[left] == m) {
                //System.out.println("m과 같아요");
                min = (arr[right] - arr[left]);
                //System.out.println("min: " + min);
                break;
            } else if (arr[right] - arr[left] > m) {
                min = Math.min(arr[right] - arr[left], min);
                left++;
                //System.out.println("left 늘렸어요 min: " + min);
            } else {
                right++;
                //System.out.println("right 늘렸어요");
            }

        }
        System.out.println(min);
    }


}