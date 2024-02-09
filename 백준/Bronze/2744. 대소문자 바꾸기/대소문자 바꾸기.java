import java.util.Scanner;

public class Main {
    static String targetStr;

    public static void main(String[] args) {
        input();
        solve();


    }

    private static void solve() {

        String upperS = targetStr.toUpperCase();
        String lowerS = targetStr.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<targetStr.length(); i++){
            if(targetStr.charAt(i)-0>96){
                sb.append(upperS.charAt(i));
            }else{
                sb.append(lowerS.charAt(i));
            }
        }
        System.out.println(sb.toString());

    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        targetStr = sc.next();

    }
}