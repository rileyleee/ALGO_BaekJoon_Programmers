import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int k, size;
    static int[] num;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        k = sc.nextInt(); 
        size = (int)(Math.pow(2,k)-1); // 완전이진트리라 개수 구할 수 있음
        tree = new ArrayList[k+1];
        num = new int[size+1];

        for(int i =0; i<=k; i++){
            tree[i] = new ArrayList<>();
        }
        // 중위순회 탐색한 거 배열에 저장
       for(int i =1; i<=size; i++){
           num[i] = sc.nextInt();
       }

       recursion(1,1,size);

       for(int i =1;i<=k;i++){
           for(int j =0; j<tree[i].size(); j++){
               sb.append(tree[i].get(j)+" ");
           }
           sb.append("\n");
       }

        System.out.println(sb.toString());

    }

    private static void recursion(int depth, int start, int end) {
        //루트노드
        int mid = (start+end)/2;
        tree[depth].add(num[mid]);
        if(depth==k){
            return;
        }
        //왼쪽자식
        recursion(depth+1, start, mid-1);
        //오른쪽자식
        recursion(depth+1, mid+1, end);
    }
}