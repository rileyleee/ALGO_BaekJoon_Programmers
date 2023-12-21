import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int l = sc.nextInt();
        int s = sc.nextInt();
        
        // 그냥 리스트로 하면 시간초과
        HashSet<String>set = new HashSet<>();

        List<String> lsList = new ArrayList<>();

        for(int i =0; i<l; i++) {
            set.add(sc.next());
        }

        for(int i =0; i<s; i++){
            String str = sc.next();

            if(set.contains(str)){
                lsList.add(str);
            }
        }



        sb.append(lsList.size()).append("\n");

        Collections.sort(lsList);

        for(int i =0; i<lsList.size(); i++) {
            sb.append(lsList.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }
}