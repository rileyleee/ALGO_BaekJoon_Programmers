import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static class MemberInfo {
        int registerOrder;
        int age;
        String name;

        public MemberInfo(int x, int y, String str) {
            this.registerOrder = x;
            this.age = y;
            this.name = str;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        MemberInfo[] memberList = new MemberInfo[n];

        for (int i = 0; i < n; i++) {
            int thisAge = sc.nextInt();
            String thisName = sc.next();
            memberList[i] = new MemberInfo(i, thisAge, thisName);
        }


        Arrays.sort(memberList, (o1, o2) -> {
            if (o1.age == o2.age) { // 가틍면 가입 순
                return o1.registerOrder - o2.registerOrder;
            } else { // 나이 오름차순
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<n; i++) {
            sb.append(memberList[i].age + " "+memberList[i].name+"\n");
        }

        System.out.println(sb.toString());
    }
}