import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] triangleNum = new int[50];
    public static boolean[] isSumOfTriangle = new boolean[1000];
    public static boolean[] isEurekaNum = new boolean[1001];

    public static void main(String[] args) {
        preprocess();

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(isEurekaNum[n] ? 1 : 0);
        }


    }

    private static void preprocess() {

        // 1000 미만까지의 삼각수 만들어 놓기
        int k = 1000;
        int idx = 1;

        for (int i = 1; ; i++) {
            //System.out.println("i: " + i);
            int thisNum = i * (i + 1) / 2;
            if (thisNum >= k) {
                //System.out.println(i);
                break;
            }
            triangleNum[idx++] = thisNum;
            //System.out.println("thisNum: "+thisNum);
        }
        //System.out.println(idx);
        //System.out.println(Arrays.toString(triangleNum));

        // 세개의 삼각수의 합으로 표현이 되는 수인지 확인
        // 단순히 삼중 반복문 대신 이중 반복문으로만 처리해서 시간 복잡도 줄이기
        // 1000 이하의 삼각수를 가지는 인덱스를 idx로 구했으니 활용!
        for (int i = 1; i < idx; i++) {
            for (int j = 1; j < idx; j++) {
                if (triangleNum[i] + triangleNum[j] < 1000) { // 두개의 수가 천보다 작아서 다른 한 수를 더 더해 타겟 수가 될 수 있다면
                    isSumOfTriangle[triangleNum[i] + triangleNum[j]] = true; // 가능성이 있는 두개의 조합이니 true로 만들어줌
                }
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (isSumOfTriangle[i]) { // 천을 넘지 않는 조합이었다면
                for (int j = 1; j < idx; j++) { // 나머지 한 수 더해보자
                    int eurekaNum = i + triangleNum[j]; // 세 수의 합을 정의하고
                    if (eurekaNum > 1000) break; // 천 보다 크면 버리고
                    isEurekaNum[eurekaNum] = true; // 천보다 작으면 그 인덱스를 true로 변경
                }
            }
        }


    }
}