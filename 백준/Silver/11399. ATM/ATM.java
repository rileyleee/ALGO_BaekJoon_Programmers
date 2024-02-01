import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int [] time = new int[n];


        time[0]  = arr[0];

        long answer = time[0];

        for(int i =1; i<n; i++){
            time[i] = time[i-1]+arr[i];
            answer +=time[i];
        }

        System.out.println(answer);
    }
}