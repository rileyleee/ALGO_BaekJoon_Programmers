import java.util.Scanner;

public class Main {
    static class point {
        double x;
        double y;
        double z;

        public point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        point a = new point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        point b = new point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        point c = new point(sc.nextInt(), sc.nextInt(), sc.nextInt());


        point start = a;
        point end = b;


        double min = Double.MAX_VALUE;

        int idx = 10000;

        while (idx-- > 0) {
            //System.out.println("여기 들어왔나요");

            point mid = new point((start.x + end.x) / 2, (start.y + end.y) / 2, (start.z + end.z) / 2);

            if (dist(start, c) > dist(end, c)) {
                start = mid;
            } else {
                end = mid;
            }

            // 두 점이 같아진다면 반복문 나오기
            if (start.x == end.x && start.y == end.y && start.z == end.z) {
                break;
            }
            // 시작 점과 c 점  그리고 끝점과 c점의 거리가 오차 범위 내보다 작을 때
            // 즉, 같다고 볼만할 때 종료하게 만드는 조건문으로 위 조건문과 같은 역할을 함
//            if (Math.abs(dist(start, c)- dist(end, c))<1e-6) {
//                break;
//            }

        }

        min = (Math.min(dist(start, c), dist(end, c))*10000000000.0)/10000000000.0;

        // 아래와 같이 큰 수를 나누고 다시 곱하는 것은
        // 부동 소수점 연산으로 인한 정밀도 손실을 줄이기 위한 것

        System.out.printf("%.10f",min);
    }

    private static double dist(point start, point c) {
        double distance = Math.sqrt(Math.pow(c.x - start.x, 2) + Math.pow(c.y - start.y, 2) + Math.pow(c.z - start.z, 2));

        //System.out.println("distance: " + distance);

        return distance;
    }
}