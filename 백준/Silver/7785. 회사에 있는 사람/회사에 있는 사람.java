import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashSet<String> names = new HashSet<>();

        while (n-- > 0) {
            String name = sc.next();
            String state = sc.next();

            if (state.equals("enter")) names.add(name);
            else names.remove(name);
        }

        int len = names.size();

        String [] attendList = new String[len];

        Iterator<String> iterator = names.iterator();

        int idx = 0;

        while(iterator.hasNext()){
            attendList[idx++] = iterator.next();
        }

        Arrays.sort(attendList, Comparator.reverseOrder());

        for(int i =0; i<len; i++){
            System.out.println(attendList[i]);
        }

    }
}