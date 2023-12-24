import java.util.*;

public class Main {

    static int n, m, chickenDist;

    static class chicken {
        int row;
        int col;

        public chicken(int x, int y) {

            this.row = x;
            this.col = y;

        }
    }

    static class house {
        int row;
        int col;

        public house(int x, int y) {

            this.row = x;
            this.col = y;

        }
    }

    static List<house> houseList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] town = new int[n + 1][n + 1];

        List<chicken> list = new ArrayList<>();
        houseList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                town[i][j] = sc.nextInt();

                if (town[i][j] == 2) {
                    list.add(new chicken(i, j));
                }
                if (town[i][j] == 1) {
                    houseList.add(new house(i, j));
                }

            }
        }

        chickenDist = Integer.MAX_VALUE;

        // 치킨집 m개 고르기
        select(list, 0, new ArrayList<>());


//        for (int i = 0; i < houseList.size(); i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < selectedlist.size(); j++) {
//
//                System.out.println("집 행:"+houseList.get(i).row );
//                System.out.println("치킨 행:"+selectedlist.get(i).row );
//                System.out.println("집 열:"+houseList.get(i).col );
//                System.out.println("치킨 열:"+selectedlist.get(i).col );
//
//                int currDist = Math.abs(houseList.get(i).row - selectedlist.get(j).row) + Math.abs(houseList.get(i).col - selectedlist.get(j).col);
//                min = Math.min(min, currDist);
//            }
//            System.out.println("min: "+ min);
//            chickenDist += min;
//        }
        System.out.println(chickenDist);
    }

    private static void select(List<chicken> list, int curr, ArrayList<chicken> selected) {

        if (selected.size() == m) {
            int thisDist = 0;
//            System.out.println("출력합니다.");
//            for (chicken c : selected) {
//                System.out.println("치킨집 선택: (" + c.row + ", " + c.col + ")");
//            }
//
//            System.out.println("selected 크기: "+ selected.size());

            for (int i = 0; i < houseList.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < selected.size(); j++) {

//                    System.out.println("집 행:"+houseList.get(i).row );
//                    System.out.println("치킨 행:"+selected.get(j).row );
//                    System.out.println("집 열:"+houseList.get(i).col );
//                    System.out.println("치킨 열:"+selected.get(j).col );

                    int currDist = Math.abs(houseList.get(i).row - selected.get(j).row) + Math.abs(houseList.get(i).col - selected.get(j).col);
                    min = Math.min(min, currDist);
                }
//                System.out.println("min: "+ min);
                thisDist += min;

            }
            chickenDist = Math.min(thisDist, chickenDist);
        }else {
            for (int i = curr; i < list.size(); i++) {
                selected.add(list.get(i));
                select(list, i + 1, selected);
                selected.remove(selected.size() - 1); // 백트래킹 직전에 뽑은 거 취소
            }
        }
    }
}