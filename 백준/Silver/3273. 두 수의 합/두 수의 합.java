import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];

        for(int i =0; i<len; i++){
            arr[i] = sc.nextInt();
        }

        int num = sc.nextInt();

        long answer = 0;

        Arrays.sort(arr);

        int a = 0;
        int b = len-1;

        while(a<=b){

            if(a==b){
                break;
            }

            if(arr[a]+arr[b]==num){
                a++;
                b--;
                answer++;
            }else if(arr[a]+arr[b]>num){
                b--;
            }else if(arr[a]+arr[b]<num){
                a++;
            }
        }
        System.out.println(answer);
    }
}