import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<(int)Math.pow(n,2); i++){
            int thisNum = sc.nextInt();
            pq.add(thisNum);
        }


        for(int i = 1; i<=n; i++){


            if(i==n){
                System.out.println(pq.peek());
            }
            pq.poll();
        }
    }
}