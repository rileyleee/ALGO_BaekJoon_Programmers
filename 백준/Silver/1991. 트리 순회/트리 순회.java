import java.util.Scanner;

public class Main {

    static int n;
    static int [][] tree;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        tree = new int [26][2]; // 각 노드의 개수와 왼, 오 자식 노드
        // 트리 입력
        for(int i =0; i<n; i++){ // 각 노드 값을 0부터 ~ 25로 설정
            int node = sc.next().charAt(0)-'A';
            int cL = sc.next().charAt(0)-'A';
            int cR = sc.next().charAt(0)-'A';
            // '.' = 46 'A' = 65
            // 노드가 없으면 -1로 넣고 노드가 있으면 입력 받은 값
            tree[node][0] = (cL == -19) ? -1: cL;
            tree[node][1] = (cR == -19) ? -1: cR;
        }
        Answer();
    }

    private static void Answer() {
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb.toString());
    }



    private static void preOrder(int i) {
        if(i==-1) return; // 해당 노드가 없으면 종료

        sb.append((char)(i+'A')); //알파벳으로 바꾸기
        preOrder(tree[i][0]);
        preOrder(tree[i][1]);
    }

    private static void inOrder(int i) {
        if(i==-1) return; // 해당 노드가 없으면 종료

        inOrder(tree[i][0]); // 츌력하지 않고 내려감
        sb.append((char)(i+'A')); //알파벳으로 바꾸기
        inOrder(tree[i][1]);
    }

    private static void postOrder(int i) {
        if(i==-1) return; // 해당 노드가 없으면 종료

        postOrder(tree[i][0]);
        postOrder(tree[i][1]);
        sb.append((char)(i+'A')); //알파벳으로 바꾸기
    }
}