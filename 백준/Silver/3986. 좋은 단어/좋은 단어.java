import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int cnt = 0;


        for (int i = 0; i < num; i++) {

            String word = sc.next();
            //System.out.println("this word: "+word);
            Stack<Character> stk = new Stack<>();

            boolean aExist = false;
            boolean bExist = false;

            for (int j = 0; j < word.length(); j++) {

                char thisChar = word.charAt(j);

                if (stk.isEmpty()) {
                    stk.push(thisChar);
                    if (thisChar == 'A') {
                        aExist = true;
                    } else {
                        bExist = true;
                    }
                } else {
                    if (stk.peek() != thisChar) {
                        if (thisChar == 'A' && !aExist || thisChar == 'B' && !bExist || aExist && bExist) {
                            stk.push(thisChar);
                            if (thisChar == 'A') {
                                aExist = true;
                            } else {
                                bExist = true;
                            }
                        } else {
                            break;
                        }

                    } else {
                        if (thisChar == 'A') {
                            aExist = false;
                            stk.pop();
                        } else {
                            bExist = false;
                            stk.pop();
                            
                        }
                    }
                }
            }
            if (stk.isEmpty()) {
                //System.out.println("** good word: "+word);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}