import java.util.Scanner;

public class Main {
    static int x, r, c, repeatNum, currentNum;
    static boolean rowTurn;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();

        r = 1;
        c = 1;

        // 행만 추가되고 경우 true 열만 추가되는 경우 false
        // 그 이후 반복되는 작업에서 true 인 경우 행 -- 열++ // false인 경우 열 -- 행 ++
        rowTurn = false;

        // repeatNum이 하나씩 증가됨
        repeatNum = 0;

        // 현재 숫자
        currentNum = 1;

        //for(int i =0; i<10; i++){

        while (currentNum != x) {
            //System.out.println("while문 시작해요 r: " + r + " c: " + c);

            // 행만 증가되는 때
            if (rowTurn) {
                r++;
                //System.out.println("rowTurn true임 r: " + r + " c: " + c);

            } else {
                c++;
                //System.out.println("rowTurn false임 r: " + r + " c: " + c);

            }
            //System.out.println("while문 r: " + r + " c: " + c);

            currentNum++;
            repeatNum++;

            //System.out.println("while문 repeatNum: " + repeatNum);

            if (currentNum == x) {
                break;
            }


            doZigZag();

            rowTurn = !rowTurn; // 반대로 변경
            //System.out.println("rowTurn: "+rowTurn);

            //System.out.println("===========================================");
        }

        StringBuilder sb = new StringBuilder();

        sb.append(r + "/" + c);

        System.out.println(sb.toString());

    }

    private static void doZigZag() {
        for (int i = 0; i < repeatNum; i++) {


            if (rowTurn) {
                c++;
                r--;

            } else {
                c--;
                r++;
            }

            currentNum++;

            if (currentNum == x) {
                break;
            }
            //System.out.println("메서드 currentNum: " + currentNum);
            //System.out.println("메서드 r: " + r + " c: " + c);
        }
    }
}