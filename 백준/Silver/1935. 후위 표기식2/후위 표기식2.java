import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double answer = 0.0;

        int num = sc.nextInt();
        String back = sc.next();

        int [] numArr = new int[num+1];

        for(int i = 1; i<=num; i++){
            numArr[i] = sc.nextInt();
        }

        Stack<Double>stk = new Stack<>();

        for(int i =0; i<back.length(); i++){
            char thisChr = back.charAt(i);

            //System.out.println(thisChr-64);

            if(thisChr-64>=1){ // 대문자 알파벳이면 스택에 넣기
                stk.add(Double.valueOf(numArr[thisChr-64]));
            }else{ // 연산자이면
                double b = stk.pop();
                double a = stk.pop();
                switch(thisChr){
                    case '*':
                        stk.add(a*b);
                        break;
                    case '-':
                        stk.add(a-b);
                        break;
                    case '+':
                        stk.add(a+b);
                        break;
                    case '/':
                        stk.add(a/b);
                        break;
                }

            }

        }

        answer = (double) stk.pop();

        System.out.printf("%.2f",answer);

    }
}