import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //cnt를 세어야 하는 경우 BFS
        //BFS는 queue로 구현
        //그 외의 경우 편한 것으로 구현

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n==k){
            System.out.println(0);
            return;
        }

        boolean [] visited = new boolean[100001];

        visited [n] = true;

        Queue<Integer> qu = new LinkedList<>();

        qu.add(n);

        int size = qu.size();

        int cnt = 0;

        while(true){

            cnt++;
            size = qu.size();

            for(int i =0; i<size; i++){
                int x = qu.remove(); //poll은 null 값 반환 romove는 런타임 에러 발생

                visited[x] = true;

                if(x-1==k || x+1 ==k || x*2==k){
                    System.out.println(cnt);
                    return;
                }

                if(x-1>=0 && !visited[x-1]){
                    visited[x-1] = true;
                    qu.add(x-1);
                }

                if(x+1<=100000 && !visited[x+1]){
                    visited[x+1] = true;
                    qu.add(x+1);
                }

                if(x*2<=100000 && !visited[x*2]){
                    visited[x*2] = true;
                    qu.add(x*2);
                }


            }

        }
    }
}