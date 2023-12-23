import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[]arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {

            int n = sc.nextInt();

            int num = (int) Math.pow(3, n);

            arr = new char[num];

            StringBuilder sb = new StringBuilder();


            Arrays.fill(arr, '-');

            changeStr(0, num);

            for(int i =0; i<arr.length; i++){
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }

    private static void changeStr(int start, int length) {

        if (length <= 1) {
            return;
        }

        int newLen = length/3;

        for(int i = start+newLen; i<start+newLen*2; i++){
            arr[i] = ' ';
        }

        // 앞 부분 다시 공백 만들기
        changeStr(start, newLen);

        // 뒷 부분 다시 공백 만들기
        changeStr(start+newLen*2, newLen);
    }
}