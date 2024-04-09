import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Deque<Character> basic = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Integer> num = new HashMap<>();

        map.put('(', ')');
        map.put('[', ']');
        num.put('(', 2);
        num.put('[', 3);
        num.put(')', 2);
        num.put(']', 3);

        int ans = 0;
        int multiple = 1;


        if (str.toCharArray().length % 2 == 0) {

            char lastLetter = '-';

            for (char c : str.toCharArray()) {
                // 여는 괄호라면
                if (map.containsKey(c)) {

                    basic.push(c);
                    multiple *= num.get(c);
                    
                }
                // 이번에 넣는 값이 닫는 괄호이고
                else {
                    //만약 스택 상단의 값과 일치한다면 pop
                    if (!basic.isEmpty() && map.containsKey(basic.peek()) && map.get(basic.peek()) == c) {
                        basic.pop(); 
                        // 직전에 넣은 값이 여는 괄호였다면
                        if (map.containsKey(lastLetter)) {
                            ans += multiple;
                        }
                        multiple /= num.get(c);
                    } else {
                        basic.push(c);
                    }
                }
                lastLetter = c;
            }
        }

        if (!basic.isEmpty()) ans = 0;
        System.out.println(ans);
    }


}