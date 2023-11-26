import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] kArr = new int[k];

        for (int i = 0; i < k; i++) {
            kArr[i] = sc.nextInt();
        }

        Arrays.sort(kArr);

        long answer = 0;

        long left = 1;
        long right = kArr[k-1];

        while(left<=right){
            long mid = (left+right)/2;

            long max = 0;

            for(int i =0; i<kArr.length; i++){
                max += kArr[i]/mid;
            }

            if(max<n){
                right = mid-1;
            }else{
                answer = mid;
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
}