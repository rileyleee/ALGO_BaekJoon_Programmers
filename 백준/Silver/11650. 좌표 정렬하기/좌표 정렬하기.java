import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    //좌표 정렬하기
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        ArrayList<Integer>[] point = new ArrayList[200001];

        for (int i = 0; i < 200001; i++) {
            point[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < num; i++) {
            int x = sc.nextInt()+100000;
            int y = sc.nextInt();

            point[x].add(y);
        }


        for (int i = 0; i < 200001; i++) {
            // 오름차순 정렬
            Collections.sort(point[i]);
            // 내림차순 정렬
            // Collections.sort(point[i], Collections.reverseOrder());
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < 200001; i++) {

            if (point[i].size() != 0) {
                for (int j = 0; j < point[i].size(); j++) {
                    sb.append(i-100000).append(" ").append(point[i].get(j)).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}