import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {

            StringBuilder sb = new StringBuilder();

            for (int start = i; start < s.length(); start++) {
                sb.append(s.charAt(start));
            }

            if (i != 0) {

                for (int end = 0; end < i; end++) {
                    sb.append(s.charAt(end));
                }
            }

            //System.out.println(sb.toString());

            if (check(sb.toString())) {
                answer++;
            }
        }

        System.out.println(answer);
        
        return answer;
    }
    
    
    private static boolean check(String newString) {
        Stack<Character> stk = new Stack<>();

        boolean right = true;

        outer:
        for (int i = 0; i < newString.length(); i++) {
            char thisLetter = newString.charAt(i);

            if (stk.isEmpty()) {
                // 닫는 괄호이면 false 반환
                if (thisLetter == ')' || thisLetter == ']' || thisLetter == '}') {
                    right = false;
                    break;
                } else { // 여는 괄호이면 일단 push
                    stk.push(thisLetter);
                }
            } else {
                switch (thisLetter) {
                    case '(':
                    case '{':
                    case '[':
                        stk.push(thisLetter);
                        break;
                    case ')':
                        if (stk.peek() == '(') {
                            stk.pop();
                        } else {
                            right = false;
                            break outer;
                        }
                        break;
                    case '}':
                        if (stk.peek() == '{') {
                            stk.pop();
                        } else {
                            right = false;
                            break outer;
                        }
                        break;
                    case ']':
                        if (stk.peek() == '[') {
                            stk.pop();
                        } else {
                            right = false;
                            break outer;
                        }
                        break;
                }
            }
        }

        if (right) {
            if(stk.isEmpty()){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }

    }
}