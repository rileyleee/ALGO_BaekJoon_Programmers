import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int []arr = new int[n];

        for(int i =0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Integer>stk = new Stack<>();

        int num = 0;

        for (int i = 0; i < n; i++) {
            int thisNum = arr[i];

            if(thisNum > num){
                for (int j = num+1; j <= thisNum; j++) {
                    stk.push(j);
                    sb.append('+').append('\n');
                }
                num = thisNum;
            } else if(stk.peek() != thisNum){
                System.out.println("NO");
                return;
            }
            stk.pop();
            sb.append('-').append('\n');
        }



        System.out.println(sb.toString());
    }
}