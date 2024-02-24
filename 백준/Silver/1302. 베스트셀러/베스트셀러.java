import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> books = new HashMap<>();

        int maxSelling = 0;
        String maxBook = "z";

        while (n-- > 0) {
            String thisBook = sc.next();

            if (books.containsKey(thisBook)) { // 이미 있으면 권 수 더하고
                books.replace(thisBook, books.get(thisBook) + 1);
            } else { // 없으면 map에 넣기
                books.put(thisBook, 1);
            }
            // 최대 권수 구하고
            maxSelling = Math.max(maxSelling, books.get(thisBook));
        }
        //System.out.println(maxSelling);

        for (String title : books.keySet()) { // 맵 돌면서
            if (maxSelling == books.get(title)) { // 최대 권수 가진 책이면
                //maxBook = title; // 최대 권 수 책제목에 담고
                //System.out.println("이번 책은: "+ title);
                if (maxBook.compareTo(title) > 0) { // 기존의 책보다 사전 순으로 앞서면
                    //System.out.println("선택된 책은" + title);
                    maxBook = title; // 앞서는 책으로 담아주기
                }
            }
        }

        System.out.println(maxBook);


    }
}