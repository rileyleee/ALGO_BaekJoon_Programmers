import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();

    }


    private static void solve() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        String ans = "";

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n + 1];

            arr[1] = 1;

            for (int i = 1; i <= n; i++) {
                arr[i] = arr[i-1] + i;
            }

            //System.out.println(Arrays.toString(arr));

            boolean find = false;
            outer: for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= n; k++) {
                        if(arr[i]+arr[j]+arr[k]== n){
                            ans += "1"+"\n";
                            find = true;
                            break outer;
                        }
                    }
                }
            }

            if(!find){
                ans+="0"+"\n";
            }
        }

        System.out.println(ans);
    }
}