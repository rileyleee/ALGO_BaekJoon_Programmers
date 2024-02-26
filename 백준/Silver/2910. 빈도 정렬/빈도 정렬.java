import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> order = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int thisNum = sc.nextInt();
            //System.out.println("이번 숫자는: " + thisNum);
            if (map.containsKey(thisNum)) {
                //System.out.println("존재해요");
                int thisValue = map.get(thisNum);
                map.replace(thisNum, thisValue, thisValue + 1);
            } else {
                //System.out.println("없어요");
                map.put(thisNum, 1);
            }

            if (!order.containsKey(thisNum)) {
                //System.out.println(thisNum+"의 순서는: "+i);
                order.put(thisNum, i);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());


        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2)) {
//                    System.out.println("o1의 키: "+o1);
//                    System.out.println("o2의 키: "+o2);
//                    System.out.println("o1의 값: "+map.get(o1));
//                    System.out.println("o2의 값: "+map.get(o2));
//                    System.out.println("o1의 순서: " +order.get(o1));
//                    System.out.println("o2의 순서: " + order.get(o2));
                    return order.get(o1) - order.get(o2);
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }
        });

        StringBuilder sb = new StringBuilder();


        for (int key : keySet) {
            for (int i = 0; i < map.get(key); i++) {
                sb.append(key + " ");
            }
        }
        System.out.println(sb);

    }
}