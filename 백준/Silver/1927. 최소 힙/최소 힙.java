import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<n; i++){


            int x = sc.nextInt();

            if(x!=0) {
                heap.add(x);
            }else{

                if(heap.size()==0){
                    sb.append("0").append("\n");
                }else {
                    sb.append(heap.poll()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}