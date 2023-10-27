import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack stk = new Stack<String>();

        int comm = sc.nextInt();

        for(int c =0; c<comm; c++){
            String num =sc.next();
            switch (num){
                case "1":
                    String push = sc.next();
                    stk.add(push);
                    break;
                case "2":
                    if(!stk.isEmpty()){
                        sb.append(stk.pop()).append("\n");
                    }else{
                        sb.append("-1").append("\n");
                    }
                    break;
                case "3":
                    sb.append(String.valueOf(stk.size())).append("\n");
                    break;
                case "4":
                    if(!stk.isEmpty()){
                        sb.append("0").append("\n");
                    }else{
                        sb.append("1").append("\n");
                    }
                    break;
                case "5":
                    if(!stk.isEmpty()){
                        sb.append(stk.peek()).append("\n");
                    }else{
                        sb.append("-1").append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}