import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase(); //모두 소문자로 변경하고

        String[] chars = s.split(""); //모든 글자를 하나씩 쪼개서 배열에 넣고

        boolean upper = true;
        StringBuilder sb = new StringBuilder();

        for (String c : chars) {
            if (upper) { //시작은 대문자로 시작
                sb.append(c.toUpperCase());
            } else {
                sb.append(c);
            }

            upper = !upper; // 대문자 여부 변경해주고
            if (c.equals(" ")) { // 만약 해당 문자가 공백이면
                upper = true; // 다시 대문자로 시작하도록 변경
            }
        }

        return sb.toString();
    }
}