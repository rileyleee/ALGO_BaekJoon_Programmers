import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            int thisNum = sc.nextInt();
            arr[i] = thisNum;
            temp[i] = thisNum;
        }

        // 임시배열은 정렬해주기
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(temp[i]))
                continue;

            map.put(temp[i], idx);
            idx++;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i + " ");
        }

        System.out.println(sb);


    }
}