import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static StringTokenizer st;
    public static char[] target;
    public static boolean[] visited;
    public static int l, c;
    public static char[] ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        target = new char[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) target[i] = st.nextToken().charAt(0);

        br.close();

        Arrays.sort(target);

        ans = new char[l];

        password(0, 0, 0);

        bw.flush();
        bw.close();
    }

    private static void password(int curr, int vowel, int consonant) throws IOException {

        if (curr == l) {
            if (vowel > 0 && consonant >= 2) {
                for (char s : ans) bw.write(s);
                bw.write("\n");
                //System.out.println("더했어요");
            }
            return;
        }

        for (int i = 0; i < c; i++) {


            if (visited[i] || (curr != 0 && ans[curr - 1] > target[i])) continue;

            ans[curr] = target[i];
            visited[i] = true;

            //System.out.println("curr: " + curr + " target[i]: " + target[i]);

            if (target[i] == 'a' || target[i] == 'e' || target[i] == 'i' || target[i] == 'o' || target[i] == 'u') {
                vowel += 1;
                //System.out.println("모음갯수: " + vowel);
            } else {
                consonant += 1;
            }
            password(curr + 1, vowel, consonant);
            visited[i] = false;
            if (target[i] == 'a' || target[i] == 'e' || target[i] == 'i' || target[i] == 'o' || target[i] == 'u') {
                vowel -= 1;
                //System.out.println("모음갯수: " + vowel);
            } else {
                consonant -= 1;
            }

        }


    }
}