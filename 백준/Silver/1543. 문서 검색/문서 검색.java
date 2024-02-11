import java.util.Scanner;

public class Main {
    static String document, target;

    public static void main(String[] args) {

        input();
        solve();

    }

    private static void solve() {

        int startIdx = 0;
        int ans = 0;

       while(true){
            int findIdx = document.indexOf(target, startIdx);
            
            if(findIdx<0){
                break;
            }
            // 찾았다면 그 단어 다음부터 또 찾아야 하니까
            startIdx = findIdx + target.length();
            ans++;
        }

        System.out.println(ans);
       
    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        document = sc.nextLine();
        target = sc.nextLine();
    }
}