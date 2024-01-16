import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // x 몸무게, y 키 -> 몸무게와 키 모두 한 쪽이 더 클 때만 덩치가 크다라고 함
    // 자신보다 더 큰 덩치를 가진 사람의 수 +1이 자신의 등수

    public static class Person {
        int w;
        int h;
        int o;

        public Person(int x, int y, int z) {

            this.w = x;
            this.h = y;
            this.o = z;

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Person> arrP = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            arrP.add(new Person(weight, height, 0));
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
//                System.out.println("=================================");
//                System.out.println("지금 인덱스 i: " + i + ", j: " + j);
                if (i != j) { // 본인 제외하고 비교해야 하기 때문

                    if (arrP.get(i).w < arrP.get(j).w && arrP.get(i).h < arrP.get(j).h) {
                        cnt++;
                    }
                }
            }
            arrP.get(i).o = cnt + 1;
        }


        for (int i = 0; i < n; i++) {
            System.out.print(arrP.get(i).o + " ");
        }


    }
}