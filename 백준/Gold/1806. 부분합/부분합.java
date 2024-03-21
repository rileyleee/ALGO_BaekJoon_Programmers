import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;

        int rightIdx = 0;
        int tmpSum = arr[0];
        for (int i = 0; i < n; i++) {
            //System.out.println("현재 i: " + i);

            while (tmpSum < s && rightIdx < n - 1) {
                tmpSum += arr[++rightIdx];
                //System.out.println("현재 tmpSum: " + tmpSum);
            }

            if (tmpSum >= s) {
                minLen = Math.min(minLen, rightIdx - i + 1);
                //System.out.println("현재 minLen: " + minLen);
            }

            tmpSum -= arr[i];
            //System.out.println("현재 값 뺐어요");
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);

    }
}