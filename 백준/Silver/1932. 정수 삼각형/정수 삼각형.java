import java.util.*;
import java.io.*;
// tip: each public class is put in its own file
public class Main
{
    public static BufferedReader br;
    public static StringTokenizer st;
    public static int[][] arr;
    public static int[][] dp;
    public static int n;
    // tip: arguments are passed via the field below this editor
    public static void main (String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int [n][n];
        dp = new int [n][n];

        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++) 
                dp[i][j] = -1;

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j< i+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            dp[n-1][i] = arr[n-1][i];
        }

        System.out.println(find(0,0));
    }

    static int find(int depth, int idx){

        if(depth==n-1) return dp[depth][idx];


        if(dp[depth][idx]==-1) {
            dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1))+ arr[depth][idx];
        }

        return dp[depth][idx];
    }
}