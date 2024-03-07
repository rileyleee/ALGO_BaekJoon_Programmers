import java.util.*;

public class Main {
    public static int n;
    public static int[] set;

    public static void main(String[] args) {

        input();
        Arrays.sort(set);

        List<Integer> twoSum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                twoSum.add(set[i] + set[j]);
            }
        }

        Collections.sort(twoSum);

        int ansIdx = 0;


        outer:
        for (int k = n - 1; k >= 0; k--) {
            for (int j = 0; j < n; j++) {

                int target = set[k] - set[j];

                int l = 0;
                int r = twoSum.size() - 1;

                while (l <= r) {
                    int mid = (l + r) / 2;
//                        System.out.println("l: " + l);
//                        System.out.println("mid: " + mid);
//                        System.out.println("r: " + r);
                    if (twoSum.get(mid) == target) {
                        ansIdx = Math.max(k, ansIdx);
//                            System.out.println("찾았음");
                        break outer;
                    } else if (twoSum.get(mid) > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

            }
        }
        System.out.println(set[ansIdx]);


    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        set = new int[n];

        for (int i = 0; i < n; i++) {
            set[i] = sc.nextInt();
        }
    }
}