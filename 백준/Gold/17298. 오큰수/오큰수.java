import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stk = new ArrayDeque<>();

        int pointer;

        for (int i = 0; i < arr.length; i++) {
            pointer = i - 1;
            // 비어있다면 스택에 값을 넣고
            if (stk.isEmpty()) stk.push(arr[i]);
            else {
                // 비어있지 않은데
                // 기존 값보다 작거나 같으면 스택에 값을 넣고
                if (stk.peek() >= arr[i]) stk.push(arr[i]);
                    // 기존 값보다 크면
                else {
                    // 기존 값이 더 작은 한
                    while (!stk.isEmpty() && stk.peek() < arr[i]) {
                        // 값이 0인 애를 찾을때 까지 pointer를 줄여가면서
                        while (ans[pointer] != 0) {
                            pointer--;
                            //System.out.println("1) 현재 pointer: " + pointer);
                        }
                        // 찾으면 값을 넣어주고
                        ans[pointer] = arr[i];
                        //System.out.println("2) 현재 pointer: " + pointer);
                        //System.out.println("넣은 값: " + arr[i]);
                        // 처리한 애는 pop해주기
                        stk.pop();
                    }
                    stk.push(arr[i]);
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) ans[i] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);

    }
}