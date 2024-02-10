import java.util.*;

public class Main {
    public static String str;

    public static void main(String[] args) {
        input();
        solve();

    }

    private static void solve() {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 96) {
                freq[str.charAt(i) - 'a']++;
            } else {
                freq[str.charAt(i) - 'A']++;
            }
        }
        //System.out.println(Arrays.toString(freq));

        int ans = 0;
        int idx = -1;


        for (int i = 0; i < freq.length; i++) {

            if (freq[i] > ans) {
                ans = freq[i];
                idx = i;
                //System.out.println("갱신된 idx: "+idx);
            }

        }

        int cnt = 0;

        for (int i = 0; i < freq.length; i++) {

            if (freq[i] == ans) {
                cnt++;
            }

        }

        if (cnt > 1) {
            System.out.println("?");
        } else {
            //System.out.println("최종 idx: "+idx);
            System.out.println((char) (idx + 65));
        }

    }

    private static void input() {

        Scanner sc = new Scanner(System.in);

        str = sc.next();

    }
}